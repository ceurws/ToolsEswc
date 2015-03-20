/**
 * FindEswcTagsOperator.java
 *
 * Created on 5. 3. 2015, 22:59:23 by burgetr
 */
package org.fit.layout.eswc.op;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import org.fit.layout.impl.BaseOperator;
import org.fit.layout.impl.DefaultTag;
import org.fit.layout.model.Area;
import org.fit.layout.model.AreaTree;
import org.fit.layout.model.Rectangular;
import org.fit.layout.model.Tag;
import org.fit.segm.grouping.AreaImpl;
import org.fit.segm.grouping.op.FindLineOperator;
import org.fit.segm.grouping.op.MultiLineOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This operator combines all the remaining operators for the ESWC tag assignment.
 * @author burgetr
 */
public class FindEswcTagsOperator extends BaseOperator
{
    private static Logger log = LoggerFactory.getLogger(FindEswcTagsOperator.class);

    private Tag tagPages = new DefaultTag("FitLayout.TextTag", "pages");
    private Tag tagEPages = new EswcTag("pages");
    
    private final String[] paramNames = {};
    private final ValueType[] paramTypes = {};

    private FindTitlesOperator opTitles;
    private FindPairsOperator opPairs;
    private FindEditorsOperator opEditors;
    
    private Area rootArea;
    private Area editedArea;
    private Area tocArea;
    private Area submittedArea;
    
    private boolean ceurPresent;
    

    
    public FindEswcTagsOperator()
    {
    }
    
    @Override
    public String getId()
    {
        return "Eswc.Tag.All";
    }
    
    @Override
    public String getName()
    {
        return "Find all ESWC tags";
    }

    @Override
    public String getDescription()
    {
        return "";
    }

    @Override
    public String[] getParamNames()
    {
        return paramNames;
    }

    @Override
    public ValueType[] getParamTypes()
    {
        return paramTypes;
    }

    //==============================================================================

    @Override
    public void apply(AreaTree atree)
    {
        apply(atree, atree.getRoot());
    }

    @Override
    public void apply(AreaTree atree, Area root)
    {
        //scan for basic areas if any
        rootArea = root;
        scanAreas();
        log.info("Edited: {}", editedArea);
        log.info("ToC: {}", tocArea);
        log.info("Submitted: {}", submittedArea);
        log.info("CEUR: {}", ceurPresent);

        //start with the whole page for all the segments
        Rectangular whole = rootArea.getBounds();
        Rectangular btitles = new Rectangular(whole);
        Rectangular beditors = new Rectangular(whole);
        Rectangular bpapers = new Rectangular(whole);

        //refine the segment bounds based on the specific areas detected
        if (editedArea != null)
        {
            btitles.setY2(editedArea.getBounds().getY1());
            beditors.setY1(editedArea.getBounds().getY1());
        }
        if (tocArea != null)
        {
            beditors.setY2(tocArea.getBounds().getY1());
            bpapers.setY1(tocArea.getBounds().getY1()); //include the ToC
        }
        if (submittedArea != null)
        {
            bpapers.setY2(submittedArea.getBounds().getY1());
        }
        
        opTitles = new FindTitlesOperator(btitles);
        opPairs = new FindPairsOperator(bpapers);
        opTitles.apply(atree, root);
        opPairs.apply(atree, root);
        log.info("TITLE: {} -> {}", btitles, opTitles.getResultBounds());
        log.info("PAPERS: {} -> {}", bpapers, opPairs.getResultBounds());

        //update the areas according to the titles and papers found
        final Rectangular bt = opTitles.getResultBounds();
        final Rectangular bp = opPairs.getResultBounds();
        //editors should be between title and papers
        if (beditors.getY1() < bt.getY2())
            beditors.setY1(bt.getY2() + 1);
        if (beditors.getY2() > bp.getY1())
            beditors.setY2(bp.getY1() - 1);
        log.info("EDITORS: " + beditors);
        //use detected region for papers
        if (tocArea == null)
            bpapers = bp; //no ToC rely completely on detected region
        else
            bpapers.setY2(bp.getY2()); //ToC present, just update Y2 
        
        //hint for editor detection: the area after 'edited by' should be a name (if everything fails)
        if (editedArea != null)
        {
            Area after = editedArea.getNextSibling();
            if (after != null)
                after.addTag(new DefaultTag("FitLayout.TextTag", "persons"), 0.3f);
        }
        //find editors
        opEditors = new FindEditorsOperator(beditors);
        opEditors.apply(atree, root);
        
        //create a super area for all the papers
        findPages(root, bpapers);
        Area apapers = createSuperAreaFromVerticalRegion(root, bpapers);
        if (apapers != null)
        {
            clearTags(apapers, "ESWC");
            FindLineOperator opLines = new FindLineOperator(true, 1.5f);
            opLines.apply(atree, apapers);
            MultiLineOperator opMLines = new MultiLineOperator(true, 0.5f);
            opMLines.apply(atree, apapers);
            opPairs = new FindPairsOperator(bpapers);
            opPairs.apply(atree, apapers);
        }
        else
            log.warn("Couldn't create the papers super-area!");
    }

    //==============================================================================

    /**
     * Finds the specific areas in the tree that indicate the start of common regions.
     */
    public void scanAreas()
    {
        ceurPresent = false;
        editedArea = null;
        tocArea = null;
        submittedArea = null;
        scanAreas(rootArea);
    }
    
    public void scanAreas(Area root)
    {
        if (root.isLeaf())
        {
            //scan for specific areas
            if (editedArea == null && root.getText().equalsIgnoreCase("Edited by"))
            {
                editedArea = root;
            }
            if (tocArea == null && root.getText().equalsIgnoreCase("Table of Contents"))
            {
                tocArea = root;
            }
            if (root.getText().toLowerCase().contains("submitted by")) //prefer the last occurence
            {
                submittedArea = root;
            }
            
            //scan for CEUR tags if their presence is not confirmed yet
            if (!ceurPresent)
            {
                Set<Tag> tags = root.getTags().keySet();
                for (Tag tag : tags)
                {
                    if ("CEUR".equals(tag.getType()))
                    {
                        ceurPresent = true;
                        break;
                    }
                }
            }
        }
        else
        {
            for (int i = 0; i < root.getChildCount(); i++)
                scanAreas(root.getChildArea(i));
        }
    }
    
    private void clearTags(Area root, String type)
    {
        Set<Tag> tags = new HashSet<Tag>(root.getTags().keySet());
        for (Tag tag : tags)
        {
            if (tag.getType().equals(type))
                root.removeTag(tag);
        }
        for (int i = 0; i < root.getChildCount(); i++)
            clearTags(root.getChildArea(i), type);
    }
    
    private Area createSuperAreaFromVerticalRegion(Area root, Rectangular region)
    {
        //find the first and last area that belong to the region
        int first = -1;
        int last = -1;
        Rectangular bounds = null;
        Vector<Area> selected = new Vector<Area>();
        for (int i = 0; i < root.getChildCount(); i++)
        {
            final Rectangular pos = root.getChildArea(i).getBounds();
            if (region.enclosesY(pos))
            {
                //System.out.println("BELONGS " + root.getChildArea(i));
                if (first == -1)
                    first = i;
                last = i;
                selected.add(root.getChildArea(i));
                if (bounds == null)
                    bounds = new Rectangular(pos);
                else
                    bounds.expandToEnclose(pos);
            }
            else
            {
                //System.out.println("NOT BELONGS " + root.getChildArea(i));
                if (first != -1)
                    break; //region finished
            }
        }
        //System.out.println("first=" + first + " last=" + last);
        if (last > first)
        {
            AreaImpl ret = new AreaImpl(bounds);
            root.insertChild(ret, first);
            for (Area a : selected)
                ret.appendChild(a);
            ((AreaImpl) root).createGrid();
            ret.createGrid();
            return ret;
        }
        else
            return null;
    }
    
    private void findPages(Area root, Rectangular region)
    {
        if (region.enclosesY(root.getBounds()) && root.hasTag(tagPages))
        {
            root.addTag(tagEPages, 1.0f);
            System.out.println("ADD TO " + root + " " + tagEPages);
        }
        for (int i = 0; i < root.getChildCount(); i++)
            findPages(root.getChildArea(i), region);
    }
    
}

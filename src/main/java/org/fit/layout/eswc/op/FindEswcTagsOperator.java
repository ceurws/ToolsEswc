/**
 * FindEswcTagsOperator.java
 *
 * Created on 5. 3. 2015, 22:59:23 by burgetr
 */
package org.fit.layout.eswc.op;

import java.util.Set;

import org.fit.layout.impl.BaseOperator;
import org.fit.layout.model.Area;
import org.fit.layout.model.AreaTree;
import org.fit.layout.model.Rectangular;
import org.fit.layout.model.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This operator combines all the remaining operators for the ESWC tag assignment.
 * @author burgetr
 */
public class FindEswcTagsOperator extends BaseOperator
{
    private static Logger log = LoggerFactory.getLogger(FindEswcTagsOperator.class);
    
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

        if (editedArea != null)
        {
            btitles.setY2(editedArea.getBounds().getY1());
            beditors.setY1(editedArea.getBounds().getY1());
        }
        if (tocArea != null)
        {
            beditors.setY2(tocArea.getBounds().getY1());
            bpapers.setY1(tocArea.getBounds().getY2());
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
            beditors.setY1(bt.getY2());
        if (beditors.getY2() > bp.getY1())
            beditors.setY2(bp.getY1());
        log.info("EDITORS: " + beditors);
        
        opEditors = new FindEditorsOperator(beditors);
        opEditors.apply(atree, root);
    }

    //==============================================================================

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
    
}

/**
 * ScanSubtitlesOperator.java
 *
 * Created on 30. 3. 2015, 14:41:18 by burgetr
 */
package org.fit.layout.eswc.op;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fit.layout.impl.BaseOperator;
import org.fit.layout.impl.DefaultTag;
import org.fit.layout.model.Area;
import org.fit.layout.model.AreaTree;
import org.fit.layout.model.Rectangular;
import org.fit.layout.model.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author burgetr
 */
public class ScanSubtitlesOperator extends BaseOperator
{
    private static Logger log = LoggerFactory.getLogger(ScanSubtitlesOperator.class);
    private static final String TT = "FitLayout.TextTag";
    
    private final String[] paramNames = {};
    private final ValueType[] paramTypes = {};

    private Rectangular bounds; //the bounds to operate on
    private Rectangular resultBounds;
    
    
    public ScanSubtitlesOperator()
    {
        this.bounds = null; //use the whole page
    }
    
    public ScanSubtitlesOperator(Rectangular bounds)
    {
        this.bounds = bounds;
    }
    
    @Override
    public String getId()
    {
        return "Eswc.Tag.Titles";
    }
    
    @Override
    public String getName()
    {
        return "Tag workshop titles";
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

    public Rectangular getResultBounds()
    {
        return resultBounds;
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
        Tag datesTag = new DefaultTag(TT, "date");
        Tag countriesTag = new DefaultTag(TT, "countries");
        
        Vector<Area> leaves = new Vector<Area>();
        findLeaves(root, leaves);
        
        Area aDate = null;
        Area aPlace = null;
        
        //date and place is the last applicable (usually)
        int last = leaves.size() - 1;
        int icoloc = -1; //collocation (if found)
        for (int i = leaves.size() - 1; i >= 0; i--)
        {
            Area a = leaves.elementAt(i);
            
            if (a.hasTag(datesTag) && aDate == null)
            {
                a.addTag(new EswcTag("vdate"), 1.0f);
                aDate = a;
                last = i;
            }
            if (a.hasTag(countriesTag) && aPlace == null)
            {
                a.addTag(new EswcTag("vcountry"), 1.0f);
                aPlace = a;
                last = i;
            }
            if (icoloc == -1 && isColocated(a))
            {
                a.addTag(new EswcTag("colocated"), 1.0f);
                icoloc = i;
            }
        }
    }
    
    //==============================================================================
    
    private boolean isColocated(Area a)
    {
        final String text = a.getText().toLowerCase().trim();
        Pattern pattern = Pattern.compile("col?\\p{Pd}*ll?ocated");
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
    
    private void findLeaves(Area root, Vector<Area> dest)
    {
        if (root.isLeaf())
        {
            if (bounds == null || root.getBounds().intersects(bounds))
                dest.add(root);
        }
        else
        {
            for (int i = 0; i < root.getChildCount(); i++)
                findLeaves(root.getChildArea(i), dest);
        }
    }
    
}

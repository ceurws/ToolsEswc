/**
 * FindPairsOperator.java
 *
 * Created on 28. 2. 2015, 21:26:03 by burgetr
 */
package org.fit.layout.eswc.op;

import org.fit.layout.impl.BaseOperator;
import org.fit.layout.impl.DefaultTag;
import org.fit.layout.model.Area;
import org.fit.layout.model.AreaTree;
import org.fit.layout.model.Rectangular;
import org.fit.layout.model.Tag;

/**
 * Finds and tags the title/authors pairs.
 * 
 * @author burgetr
 */
public class FindPairsOperator extends BaseOperator
{
    private static final String TT = "FitLayout.TextTag";
    
    private final String[] paramNames = {};
    private final ValueType[] paramTypes = {};
    
    //tags to compare to
    Tag tpersons = new DefaultTag(TT, "persons");
    Tag ttitle = new DefaultTag(TT, "title");
    Tag eauthors = new EswcTag("authors");
    Tag etitle = new EswcTag("title");

    
    public FindPairsOperator()
    {
    }
    
    @Override
    public String getId()
    {
        return "Eswc.Tag.Pairs";
    }
    
    @Override
    public String getName()
    {
        return "Tag title/authors pairs";
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
        //add tags to pairs based on their text tags
        recursivelyAddTags(root);
    }
    
    //==============================================================================
    
    private void recursivelyAddTags(Area root)
    {
        if (root.getParentArea() != null && acceptableTags(root))
        {
            //try to find an aligned area above
            Area aa = findClosestAbove(root);
            //check the tags
            if (aa != null && acceptableTags(aa))
            {
                if (root.hasTag(tpersons) && !aa.hasTag(tpersons))
                {
                    root.addTag(eauthors, 0.5f);
                    aa.addTag(etitle, 0.5f);
                }
                else if (root.hasTag(ttitle) && !aa.hasTag(ttitle))
                {
                    root.addTag(etitle, 0.5f);
                    aa.addTag(eauthors, 0.5f);
                }
            }
        }
        
        for (int i = 0; i < root.getChildCount(); i++)
            recursivelyAddTags(root.getChildArea(i));
    }

    private boolean acceptableTags(Area a)
    {
        //area is not yet tagged and has the appropriate text tags
        return (a.hasTag(tpersons) || a.hasTag(ttitle)) &&
               (!a.hasTag(eauthors) && !a.hasTag(etitle));
    }
    
    private Area findClosestAbove(Area a)
    {
        final Area parent = a.getParentArea();
        Rectangular gp = a.getTopology().getPosition();
        int y = gp.getY1();
        int mindif = Integer.MAX_VALUE;
        Area ret = null;
        if (y > 0)
        {
            //find closest left-aligned child above
            for (int i = 0; i < parent.getChildCount(); i++)
            {
                final Area child = parent.getChildArea(i);
                Rectangular cgp = child.getTopology().getPosition();
                if (cgp.getX1() == gp.getX1() && cgp.getY1() < y)
                {
                    final int dif = y - cgp.getY1();
                    if (dif < mindif)
                    {
                        ret = child;
                        mindif = dif;
                    }
                }
            }
            //sanity check: should be at most one line above
            if (ret != null)
            {
                int dy = a.getBounds().getY1() - ret.getBounds().getY1();
                if (dy > a.getBounds().getHeight() * 1.5)
                {
                    System.out.println("Too far " + a + " --- " + ret);
                    ret = null;
                }
            }
        }
        return ret;
    }
    
}

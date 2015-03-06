/**
 * FindEditorsOperator.java
 *
 * Created on 6. 3. 2015, 15:13:45 by burgetr
 */
package org.fit.layout.eswc.op;

import java.util.Vector;

import org.fit.layout.classify.NodeStyle;
import org.fit.layout.classify.StyleCounter;
import org.fit.layout.impl.BaseOperator;
import org.fit.layout.impl.DefaultTag;
import org.fit.layout.model.Area;
import org.fit.layout.model.AreaTree;
import org.fit.layout.model.Rectangular;
import org.fit.layout.model.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Finds the editor names in the given area of the page.
 * 
 * @author burgetr
 */
public class FindEditorsOperator extends BaseOperator
{
    private static Logger log = LoggerFactory.getLogger(FindEditorsOperator.class);
    private static final String TT = "FitLayout.TextTag";
    
    private final String[] paramNames = {};
    private final ValueType[] paramTypes = {};

    private Rectangular bounds;
    
    
    public FindEditorsOperator()
    {
        this(0, 300, 1200, 600); //just a guess
    }
    
    public FindEditorsOperator(int x1, int y1, int x2, int y2)
    {
        bounds = new Rectangular(x1, y1, x2, y2);
    }
    
    public FindEditorsOperator(Rectangular r)
    {
        bounds = new Rectangular(r);
    }
    
    @Override
    public String getId()
    {
        return "Eswc.Tag.Editors";
    }
    
    @Override
    public String getName()
    {
        return "Tag workshop editors";
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

    public Rectangular getBounds()
    {
        return bounds;
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
        //find tagged names in the area
        Vector<Area> names = new Vector<Area>();
        Tag tag = new DefaultTag(TT, "persons");
        findTagsInArea(root, bounds, tag, 0.5f, names);
        for (Area a : names)
            System.out.println("name: " + a);
        
        if (!names.isEmpty())
        {
            //find the group containing the last name discovered
            Vector<Area> leaves = new Vector<Area>();
            findLeavesInArea(root, bounds, leaves);
            int last = leaves.indexOf(names.lastElement());
            
            //go until the beginning of the group
            int first = last;
            Area prev = names.lastElement();
            for (int i = last - 1; i >= 0; i--)
            {
                Area cur = leaves.elementAt(i);
                if (isNeighbor(cur, prev))
                {
                    first = i;
                    prev = cur;
                }
                else
                    break;
            }
            System.out.println("Editors start:" + leaves.elementAt(first));
            
            //build statistics about names
            prev = null;
            int sameline = 0;
            int nextline = 0;
            int other = 0;
            int minx = -1;
            StyleCounter estyles = new StyleCounter();
            for (int i = first; i <= last; i++)
            {
                Area a = leaves.elementAt(i);
                if (a.hasTag(tag, 0.5f))
                {
                    estyles.add(new NodeStyle(a));
                    final int x = a.getTopology().getPosition().getX1();
                    if (prev != null)
                    {
                        if (isOnSameLine(prev, a))
                            sameline++;
                        else if (isInSameColumn(prev, a))
                            nextline++;
                        else
                            other++;
                        if (x < minx)
                            minx = x;
                    }
                    else
                        minx = x;
                    prev = a;
                }
            }
            NodeStyle estyle = estyles.getMostFrequent();
            log.info("Layout: same line {}, next line {}, other {}, minx {}, style {}", sameline, nextline, other, minx, estyle);
            
            //tag the appropriate names
            for (int i = first; i <= last; i++)
            {
                Area a = leaves.elementAt(i);
                System.out.println("Test " + a);
                if (estyle.equals(new NodeStyle(a))) //TODO do not match indentation and color(?)
                {
                    //TODO match coordinates?
                    a.addTag(new EswcTag("veditor"), 0.7f);
                    System.out.println("ok");
                }
            }
            
        }
        
        
    }
    
    //==============================================================================
    
    private void findLeavesInArea(Area root, Rectangular limit, Vector<Area> dest) 
    {
        if (root.isLeaf() && getBounds().intersects(limit))
            dest.add(root);
        for (int i = 0; i < root.getChildCount(); i++)
            findLeavesInArea(root.getChildArea(i), limit, dest);
    }
    
    private void findTagsInArea(Area root, Rectangular limit, Tag tag, float minSupport, Vector<Area> dest) 
    {
        if (root.hasTag(tag, minSupport) && root.getBounds().intersects(limit))
            dest.add(root);
        for (int i = 0; i < root.getChildCount(); i++)
            findTagsInArea(root.getChildArea(i), limit, tag, minSupport, dest);
    }
    
    private boolean isNeighbor(Area a1, Area a2)
    {
        if (isOnSameLine(a1, a2))
            return true; //on the same line
        else
        {
            //the Y difference is less than half the line height
            int dy = a2.getBounds().getY1() - a1.getBounds().getY2();
            if (dy < 0)
                dy = a1.getBounds().getY1() - a2.getBounds().getY2();
            return dy < a1.getBounds().getHeight() / 2;
        }
    }
    
    private boolean isOnSameLine(Area a1, Area a2)
    {
        final Rectangular gp1 = a1.getTopology().getPosition();
        final Rectangular gp2 = a2.getTopology().getPosition();
        return (gp1.getY1() == gp2.getY1() && gp1.getY2() == gp2.getY2()); 
    }
    
    private boolean isInSameColumn(Area a1, Area a2)
    {
        final Rectangular gp1 = a1.getTopology().getPosition();
        final Rectangular gp2 = a2.getTopology().getPosition();
        return (gp1.getX1() == gp2.getX1()); 
    }
    
}

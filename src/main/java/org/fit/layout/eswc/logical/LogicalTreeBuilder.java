/**
 * LogicalTreeBuilder.java
 *
 * Created on 19. 3. 2015, 13:54:48 by burgetr
 */
package org.fit.layout.eswc.logical;

import java.util.Vector;

import org.fit.layout.eswc.op.EswcTag;
import org.fit.layout.impl.BaseLogicalTreeProvider;
import org.fit.layout.impl.DefaultTag;
import org.fit.layout.model.Area;
import org.fit.layout.model.AreaTree;
import org.fit.layout.model.LogicalArea;
import org.fit.layout.model.LogicalAreaTree;
import org.fit.layout.model.Tag;

/**
 * 
 * @author burgetr
 */
public class LogicalTreeBuilder extends BaseLogicalTreeProvider
{
    private static Tag tagRoot = new EswcTag("root");
    private static Tag tagVTitle = new EswcTag("vtitle");
    private static Tag tagVEditor = new EswcTag("veditor");
    private static Tag tagEAffil = new EswcTag("eaffil");
    private static Tag tagECountry = new EswcTag("ecountry");
    private static Tag tagPaper = new EswcTag("paper");
    private static Tag tagAuthor = new EswcTag("authors");
    private static Tag tagTitle = new EswcTag("title");
    private static Tag tagPages = new EswcTag("pages");
    private static Tag tagStartPage = new EswcTag("pstart");
    private static Tag tagEndPage = new EswcTag("pend");
    
    private EswcLogicalTree tree;
    private LogicalArea rootArea;
    private Vector<Area> leaves;
    
    private int iTitle = -1;
    private int editorStart = -1;
    private int editorEnd = -1;
    private int paperStart = -1;
    private int paperEnd = -1;

    @Override
    public String getId()
    {
        return "CEUR.Logical";
    }

    @Override
    public String getName()
    {
        return "CEUR Logical Tree Builder";
    }

    @Override
    public String getDescription()
    {
        return "Logical structure builder for CEUR proceedings";
    }

    @Override
    public String[] getParamNames()
    {
        return new String[0];
    }

    @Override
    public ValueType[] getParamTypes()
    {
        return new ValueType[0];
    }

    //====================================================================================
    
    @Override
    public LogicalAreaTree createLogicalTree(AreaTree areaTree)
    {
        rootArea = createRoot(areaTree);
        tree = new EswcLogicalTree(areaTree);
        tree.setRoot(rootArea);
        
        leaves = new Vector<Area>();
        findLeaves(areaTree.getRoot(), leaves);
        
        scanLeaves();
        
        addVTitle();
        addPapers();
        
        return tree;
    }

    private void findLeaves(Area root, Vector<Area> dest)
    {
        if (root.isLeaf())
        {
            dest.add(root);
        }
        else
        {
            for (int i = 0; i < root.getChildCount(); i++)
                findLeaves(root.getChildArea(i), dest);
        }
    }
    
    private void scanLeaves()
    {
        int i = 0;
        for (Area a : leaves)
        {
            if (iTitle == -1 && a.hasTag(tagVTitle))
                iTitle = i;
            if (a.hasTag(tagVEditor))
            {
                if (editorStart == -1) editorStart = i;
                editorEnd = i;
            }
            if (a.hasTag(tagTitle) || a.hasTag(tagAuthor) || a.hasTag(tagPages))
            {
                if (paperStart == -1) paperStart = i;
                paperEnd = i;
            }
            
            i++;
        }
    }
    
    private LogicalArea createRoot(AreaTree tree)
    {
        String uri = tree.getRoot().getAllBoxes().firstElement().getPage().getSourceURL().toString();
        return new EswcLogicalArea(tree.getRoot(), uri, tagRoot);
    }
    
    private void addVTitle()
    {
        Area root = leaves.elementAt(iTitle);
        String text = root.getText();
        rootArea.appendChild(new EswcLogicalArea(root, text, tagVTitle));
    }
    
    private void addPapers()
    {
        String curTitle = null;
        String curAuthors = null;
        String curPages = null;
        
        for (int i = paperStart; i <= paperEnd; i++)
        {
            
        }
    }
    
}

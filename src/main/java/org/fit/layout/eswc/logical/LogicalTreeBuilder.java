/**
 * LogicalTreeBuilder.java
 *
 * Created on 19. 3. 2015, 13:54:48 by burgetr
 */
package org.fit.layout.eswc.logical;

import java.util.Vector;

import org.fit.layout.eswc.op.AreaUtils;
import org.fit.layout.eswc.op.EswcTag;
import org.fit.layout.impl.BaseLogicalTreeProvider;
import org.fit.layout.model.Area;
import org.fit.layout.model.AreaTree;
import org.fit.layout.model.LogicalArea;
import org.fit.layout.model.LogicalAreaTree;
import org.fit.layout.model.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author burgetr
 */
public class LogicalTreeBuilder extends BaseLogicalTreeProvider
{
    private static Logger log = LoggerFactory.getLogger(LogicalTreeBuilder.class);
    
    private static final float ms = 0.5f;
    
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
    
    private void reset()
    {
        iTitle = -1;
        editorStart = -1;
        editorEnd = -1;
        paperStart = -1;
        paperEnd = -1;
    }
    
    @Override
    public LogicalAreaTree createLogicalTree(AreaTree areaTree)
    {
        reset();
        
        rootArea = createRoot(areaTree);
        tree = new EswcLogicalTree(areaTree);
        tree.setRoot(rootArea);
        
        leaves = new Vector<Area>();
        findLeaves(areaTree.getRoot(), leaves);
        
        scanLeaves();
        
        addVTitle();
        addEditors();
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
            if (iTitle == -1 && a.hasTag(tagVTitle, ms))
                iTitle = i;
            if (a.hasTag(tagVEditor, ms))
            {
                if (editorStart == -1) editorStart = i;
                editorEnd = i;
            }
            if (a.hasTag(tagTitle, ms) || a.hasTag(tagAuthor, ms) || a.hasTag(tagPages, ms))
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
    
    //====================================================================================

    private void addVTitle()
    {
        Area root = leaves.elementAt(iTitle);
        String text = root.getText();
        rootArea.appendChild(new EswcLogicalArea(root, text, tagVTitle));
    }
    
    //====================================================================================
    
    private void addEditors()
    {
        //extend editors till the end of the last line
        Area last = leaves.elementAt(editorEnd);
        while (editorEnd + 1 < leaves.size())
        {
            Area next = leaves.elementAt(editorEnd + 1);
            if (AreaUtils.isOnSameLineRoughly(last, next))
            {
                last = next;
                editorEnd++;
            }
            else
                break;
        }
        //find editor data
        Area curEd = null;
        StringBuilder textb = null;
        for (int i = editorStart; i <= editorEnd; i++)
        {
            Area a = leaves.elementAt(i);
            if (a.hasTag(tagVEditor, ms))
            {
                if (curEd != null)
                    saveEditor(curEd, textb.toString().trim());
                curEd = a;
                textb = new StringBuilder(a.getText());
            }
            else
            {
                if (textb != null)
                    textb.append(a.getText());
            }
        }
        if (curEd != null)
            saveEditor(curEd, textb.toString().trim());
    }
    
    private void saveEditor(Area editor, String text)
    {
        //System.out.println("ED: " + text);
        //find the name
        int i = 0;
        while (i < text.length())
        {
            char ch = text.charAt(i);
            if (ch != '.' && ch != '-' 
                    && !Character.isLetter(ch) 
                    && !Character.isSpaceChar(ch))
                break;
            i++;
        }
        if (i > 0)
        {
            String name = text.substring(0, i);
            String affil = text.substring(i).trim();
            while (affil.startsWith(","))
                affil = affil.substring(1).trim();
            while (affil.endsWith(","))
                affil = affil.substring(0, affil.length() - 1);
            
            if (affil.isEmpty())
            {
                Area follow = leaves.elementAt(editorEnd+1);
                if (AreaUtils.isNeighbor(editor, follow))
                {
                    String ftext = getTextOnLine(editorEnd+1, paperStart);
                    affil = ftext.trim();
                }
                else
                    log.warn("No affiliation for " + text);
            }
            
            affil = completeAffil(affil);
            LogicalArea aname = new EswcLogicalArea(editor, name, tagVEditor);
            rootArea.appendChild(aname);
            LogicalArea aaffil = new EswcLogicalArea(editor, affil, tagEAffil);
            aname.appendChild(aaffil);
        }
        else
            log.warn("Couldn't find editor name: {}", text);
    }
    
    private String completeAffil(String src)
    {
        if (src.length() > 0 && !Character.isLetter(src.charAt(0)))
        {
            for (int i = editorEnd + 1; i < paperStart; i++)
            {
                final Area a = leaves.elementAt(i);
                final String s = a.getText();
                if (s.trim().startsWith(src))
                {
                    String ret = getTextOnLine(i, paperStart).trim();
                    ret = ret.substring(src.length()).trim();
                    return ret;
                }
            }
            log.warn("Couldn't find affiliation for " + src);
            return src;
        }
        else
            return src;
    }
    
    //====================================================================================
    
    private void addPapers()
    {
        Area curTitle = null;
        Area curAuthors = null;
        Area curPages = null;
        
        for (int i = paperStart; i <= paperEnd; i++)
        {
            Area a = leaves.elementAt(i);
            if (a.hasTag(tagTitle, ms) || a.hasTag(tagAuthor, ms) || a.hasTag(tagPages, ms))
            {
                if (curTitle == null && a.hasTag(tagTitle, ms))
                    curTitle = a;
                else if (curAuthors == null && a.hasTag(tagAuthor, ms))
                    curAuthors = a;
                else if (curPages == null && a.hasTag(tagPages, ms))
                    curPages = a;
                else //some duplicate
                {
                    savePaper(curTitle, curAuthors, curPages);
                    curTitle = null;
                    curAuthors = null;
                    curPages = null;
                    i--; //try the same area again
                }
            }
        }
        savePaper(curTitle, curAuthors, curPages);
    }
    
    private void savePaper(Area title, Area authors, Area pages)
    {
        if (title != null && authors != null)
        {
            LogicalArea at = new EswcLogicalArea(title, title.getText().trim(), tagTitle);
            rootArea.appendChild(at);
            String saut = authors.getText().trim();
            String names[] = saut.split("\\s*[,;]\\s*(and)?\\s*");
            for (String name : names)
            {
                String nnames[] = name.split("\\s+and\\s+");
                for (String nname : nnames)
                {
                    LogicalArea aa = new EswcLogicalArea(authors, nname, tagAuthor);
                    at.appendChild(aa);
                }
            }
            if (pages != null)
            {
                String[] pp = pages.getText().trim().split("\\s*\\p{Pd}\\s*");
                if (pp.length == 2)
                {
                    LogicalArea ps = new EswcLogicalArea(pages, pp[0], tagStartPage);
                    at.appendChild(ps);
                    LogicalArea pe = new EswcLogicalArea(pages, pp[1], tagEndPage);
                    at.appendChild(pe);
                }
                else
                    log.warn("Invalid pages: {}", pages);
            }
        }
        else
            log.warn("Incomplete paper: {} : {}", title, authors);
    }
    
    private String getTextOnLine(int start, int end)
    {
        Area a = leaves.elementAt(start);
        StringBuilder sb = new StringBuilder(a.getText());
        int i = start + 1;
        while (i < end) //use all till end of line
        {
            Area next = leaves.elementAt(i);
            if (AreaUtils.isOnSameLineRoughly(a, next))
            {
                sb.append(next.getText());
                i++;
            }
            else
                break;
        }
        return sb.toString();
    }
    
}

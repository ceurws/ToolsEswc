/**
 * SubtitleParser.java
 *
 * Created on 21. 4. 2015, 11:46:01 by burgetr
 */
package org.fit.layout.eswc;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fit.layout.eswc.op.AreaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @author burgetr
 */
public class SubtitleParser
{
    private static Logger log = LoggerFactory.getLogger(SubtitleParser.class);

    public enum TType { ORD, WORKSHOP, SHORT, COLOC };
    private String src;
    private Vector<String> titleShorts;
    private Vector<Token> tokens;
    private Set<Event> ws;
    private Event colocEvent;
    
    public SubtitleParser(String inputText, Vector<String> titleShorts)
    {
        src = inputText;
        this.titleShorts = titleShorts;
        ws = new HashSet<Event>();
        tokenize();
        scanTokens();
        for (Token t: tokens)
            System.out.println(t);
    }
    
    public Set<Event> getWorkshops()
    {
        return ws;
    }

    public Event getColocEvent()
    {
        return colocEvent;
    }

    private void tokenize()
    {
        tokens = new Vector<Token>();
        
        Matcher matcher = AreaUtils.shortTitlePattern.matcher(src);
        while (matcher.find())
        {
            final String sname = matcher.group(0);
            if (sname.length() >= 2 && sname.length() <= 10 && !AreaUtils.blackShort.contains(sname))
                tokens.add(new Token(matcher.start(), TType.SHORT, sname));
        }
        
        //st nd rd th
        matcher = Pattern.compile("[1-9][0-9]*[snrt][tdh]").matcher(src.toLowerCase());
        while (matcher.find())
        {
            final String order = matcher.group(0).trim();
            tokens.add(new Token(matcher.start(), TType.ORD, order));
        }
        
        matcher = Pattern.compile("workshop|col?\\p{Pd}*ll?ocated|in conjunction|located at").matcher(src.toLowerCase());
        while (matcher.find())
        {
            final String word = matcher.group(0);
            if (word.equals("workshop"))
                tokens.add(new Token(matcher.start(), TType.WORKSHOP, word));
            else
                tokens.add(new Token(matcher.start(), TType.COLOC, word));
        }
        
        Collections.sort(tokens);
    }
    
    private void scanTokens()
    {
        //count the occurences, gather statistics
        Token coloc = null;
        Map<String, Integer> counts = new HashMap<String, Integer>();
        for (Token t : tokens)
        {
            if (t.type == TType.SHORT)
            {
                Integer cnt = counts.get(t.value); 
                if (cnt == null)
                    counts.put(t.value, 1);
                else
                    counts.put(t.value, cnt++);
            }
            else if (t.type == TType.COLOC)
                coloc = t;
        }
        
        scanTokensWithColoc(counts, coloc);
    }
    
    private void scanTokensWithColoc(Map<String, Integer> counts, Token coloc)
    {
        Set<String> titlesRemain = new HashSet<String>(titleShorts);
        int titlecnt = 0;
        Event current = new Event();
        boolean acoloc = false; //after colocation
        boolean wssure = false; //preceeded by 'workhsop'
        for (Token t : tokens)
        {
            //previous event finished, save it
            if (t.type == TType.COLOC
                    || (t.type == TType.ORD && current.order != -1) //other event with order
                    || (t.type == TType.WORKSHOP && current.sname != null) //other workshop starts
                    || (t.type == TType.SHORT && current.sname != null && current.order > 0)) //other workshop name 
            {
                if (current.sname == null) //no short name found but we try to use the next one from the title
                {
                    if (!titleShorts.isEmpty())
                        current.sname = titleShorts.elementAt(titlecnt++);
                }
                
                boolean next = true;
                if (current.sname != null)
                {
                    next = saveEvent(current, coloc != null, acoloc, wssure);
                    titlesRemain.remove(current.sname);
                }
                
                if (next)
                {
                    current = new Event();
                    wssure = false;
                }
            }
            
            if (t.type == TType.ORD)
            {
                current.order = Integer.parseInt(t.value.substring(0, t.value.length() - 2));
                wssure = false;
            }
            else if (t.type == TType.SHORT)
            {
                current.sname = t.value;
                if (current.order == -1)
                    current.order = 0; //no order found; use 0 for unknown
            }
            else if (t.type == TType.WORKSHOP)
                wssure = true;
            else if (t.type == TType.COLOC)
                acoloc = true;
        }
        if (current.sname != null)
            saveEvent(current, coloc != null, acoloc, wssure);
        if (!titlesRemain.isEmpty())
            log.warn("Remaining short names from title: " + titlesRemain);

    }

    private boolean saveEvent(Event current, boolean useColoc, boolean acoloc, boolean wssure)
    {
        if (useColoc)
        {
            if (!acoloc && (wssure || titleShorts.contains(current.sname)))
            {
                if (titleShorts.contains(current.sname)) //skip the ones not found in the title
                {
                    ws.add(current);
                    return true;
                }
            }
            else if (acoloc)
            {
                if (colocEvent == null)
                {
                    colocEvent = current;
                    return true;
                }
            }
        }
        else
        {
            if (wssure || titleShorts.contains(current.sname))
            {
                if (titleShorts.contains(current.sname)) //skip the ones not found in the title
                {
                    ws.add(current);
                    return true;
                }
            }
            else
            {
                if (colocEvent == null)
                {
                    colocEvent = current;
                    return true;
                }
            }
        }
        return false;
    }

    class Token implements Comparable<Token>
    {
        public TType type;
        public int pos;
        public String value;
        
        public Token(int pos, TType type, String value)
        {
            super();
            this.pos = pos;
            this.type = type;
            this.value = value;
        }

        @Override
        public int compareTo(Token other)
        {
            return pos - other.pos;
        }

        @Override
        public String toString()
        {
            return "Token [type=" + type + ", pos=" + pos + ", value=" + value + "]";
        }
    }
    
    class Event
    {
        int order;
        String sname;
        
        public Event()
        {
            order = -1;
            sname = null;
        }
        
        @Override
        public String toString()
        {
            return "Event [order=" + order + ", sname=" + sname + "]";
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + order;
            result = prime * result + ((sname == null) ? 0 : sname.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            Event other = (Event) obj;
            if (!getOuterType().equals(other.getOuterType())) return false;
            if (order != other.order) return false;
            if (sname == null)
            {
                if (other.sname != null) return false;
            }
            else if (!sname.equals(other.sname)) return false;
            return true;
        }

        private SubtitleParser getOuterType()
        {
            return SubtitleParser.this;
        }
        
    }
    
}

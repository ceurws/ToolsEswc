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
        for (Token t: tokens)
            System.out.println(t);
        scanTokens();
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
            if (t.type == TType.SHORT && coloc == null)
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
        
        //if colocated is found, disambiguate colocation now
        if (coloc != null)
        {
            coloc.used = true;
            for (int i = tokens.indexOf(coloc); i < tokens.size(); i++)
            {
                Token t = tokens.elementAt(i);
                if (t.type == TType.SHORT)
                {
                    t.used = true;
                    int ord = -1;
                    Token ordt = findOrdBeforeIndex(i);
                    if (ordt != null)
                    {
                        ordt.used = true;
                        ord = Integer.parseInt(ordt.value.substring(0, ordt.value.length() - 2));
                    }
                    colocEvent = new Event(ord, t.value);
                    break;
                }
            }
        }
        
        //try to find workshops
        Set<String> titles = new HashSet<String>(titleShorts);
        if (colocEvent != null)
            titles.remove(colocEvent.sname);
        Set<String> subtitles = new HashSet<String>(counts.keySet());
        if (colocEvent != null)
            subtitles.remove(colocEvent.sname);
        Set<String> supported = intersection(titles, subtitles);
        
        if (supported.isEmpty())
        {
            //no abbreviations in title or significantly more in subtitles -- scan subtitle
            if (titles.size() == 0 || (titles.size() <= 1 && subtitles.size() > 2))
                scanAbbreviations(subtitles, coloc);
            else
                scanAbbreviations(titles, coloc);
        }
        else //some intersection exists - use the intersection short names
        {
            scanAbbreviations(supported, coloc);
        }
        
        //no collocation, is some abbreviation remaining?
        if (coloc == null)
        {
            Set<String> remain = new HashSet<String>(counts.keySet());
            for (Event e : ws)
                remain.remove(e.sname);
            Vector<Integer> indices = findAbbrevIndices(remain, tokens.size());
            if (!indices.isEmpty())
            {
                Token t = tokens.elementAt(indices.firstElement());
                t.used = true;
                int ord = -1;
                Token ordt = findOrdBeforeIndex(indices.firstElement());
                if (ordt != null)
                {
                    ordt.used = true;
                    ord = Integer.parseInt(ordt.value.substring(0, ordt.value.length() - 2));
                }
                colocEvent = new Event(ord, t.value);
            }
        }
    }
    
    private void scanAbbreviations(Set<String> supported, Token coloc)
    {
        log.info("Subtitle scan for {}", supported);
        int max = (coloc == null) ? tokens.size() : tokens.indexOf(coloc);
        //create ordered list of tokens
        Vector<Integer> indices = findAbbrevIndices(supported, max);
        //try to find the numbers
        for (int idx : indices)
        {
            Token sn = tokens.elementAt(idx);
            sn.used = true;
            int ord = -1;
            Token ordt = findOrdBeforeIndex(idx);
            if (ordt != null)
            {
                ordt.used = true;
                ord = Integer.parseInt(ordt.value.substring(0, ordt.value.length() - 2));
            }
            ws.add(new Event(ord, sn.value));
        }
    }

    private int findToken(TType type, String value, int max)
    {
        for (int i = 0; i < max; i++)
        {
            final Token t = tokens.elementAt(i);
            if (t.type == type && value.equals(t.value))
                return i;
        }
        return -1;
    }
    
    private Token findOrdBeforeIndex(int index)
    {
        for (int i = index - 1; i >= 0; i--)
        {
            Token t = tokens.elementAt(i);
            if (t.used)
                break;
            if (t.type == TType.ORD)
                return t;
        }
        return null;
    }
    
    private Vector<Integer> findAbbrevIndices(Set<String> supported, int max)
    {
        Vector<Integer> indices = new Vector<Integer>();
        for (String sname : supported)
        {
            int ti = findToken(TType.SHORT, sname, max);
            if (ti != -1)
                indices.add(ti);
            else
                log.error("{} not found in subtitle, this shouldn't happen", sname);
        }
        Collections.sort(indices);
        return indices;
    }

    private Set<String> intersection(Set<String> set1, Set<String> set2) 
    {
        boolean set1IsLarger = set1.size() > set2.size();
        Set<String> cloneSet = new HashSet<String>(set1IsLarger ? set2 : set1);
        cloneSet.retainAll(set1IsLarger ? set1 : set2);
        return cloneSet;
    }

    class Token implements Comparable<Token>
    {
        public TType type;
        public int pos;
        public String value;
        public boolean used;
        
        public Token(int pos, TType type, String value)
        {
            this.pos = pos;
            this.type = type;
            this.value = value;
            this.used = false;
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
        
        public Event(int order, String sname)
        {
            this.order = order;
            this.sname = sname;
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

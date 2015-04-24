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
        
        Set<String> titles = new HashSet<String>(titleShorts);
        Set<String> supported = intersection(titles, counts.keySet());
        
        if (supported.isEmpty())
            scanAbbreviationsBlind(coloc);
        else
            scanAbbreviations(supported, coloc);
    }
    
    private void scanAbbreviations(Set<String> supported, Token coloc)
    {
        int max = (coloc == null) ? tokens.size() : tokens.indexOf(coloc);
        //create ordered list of tokens
        Vector<Token> stokens = new Vector<Token>();
        for (String sname : supported)
        {
            int ti = findToken(TType.SHORT, sname, max);
            stokens.add(tokens.elementAt(ti));
        }
        Collections.sort(stokens);
        //try to find the numbers
        
    }

    private void scanAbbreviationsBlind(Token coloc)
    {
        
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
    
    public Set<String> intersection(Set<String> set1, Set<String> set2) 
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

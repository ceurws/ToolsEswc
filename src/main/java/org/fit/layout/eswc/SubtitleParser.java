/**
 * SubtitleParser.java
 *
 * Created on 21. 4. 2015, 11:46:01 by burgetr
 */
package org.fit.layout.eswc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fit.layout.eswc.op.AreaUtils;


/**
 * 
 * @author burgetr
 */
public class SubtitleParser
{
    public enum TType { ORD, WORKSHOP, SHORT, COLOC };
    private String src;
    private Vector<String> titleShorts;
    private Vector<Token> tokens;
    private Vector<Event> ws;
    private Event colocEvent;
    
    public SubtitleParser(String inputText, Vector<String> titleShorts)
    {
        src = inputText;
        this.titleShorts = titleShorts;
        tokenize();
        for (Token t: tokens)
            System.out.println(t);
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
        matcher = Pattern.compile("[1-9][0-9]*[snrt][tdh]\\s").matcher(src.toLowerCase());
        while (matcher.find())
        {
            final String order = matcher.group(0);
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
        
        Event current = new Event();
        boolean acoloc = false; //after colocation
        boolean wssure = false; //preceeded by 'workhsop'
        for (Token t : tokens)
        {
            if (t.type == TType.COLOC
                    || (t.type == TType.ORD && current.order != -1))
            {
                if (current.sname != null)
                {
                    if (!acoloc && 
                            (wssure || titleShorts.contains(current.sname) || counts.get(current) > 1))
                    {
                        
                    }
                }
                current = new Event();
                wssure = false;
            }
            
            if (t.type == TType.ORD)
            {
                current.order = Integer.parseInt(t.value.substring(0, t.value.length() - 2));
                wssure = false;
            }
            else if (t.type == TType.SHORT)
            {
                current.sname = t.value;
            }
            else if (t.type == TType.WORKSHOP)
                wssure = true;
            else if (t.type == TType.COLOC)
                acoloc = true;
            
        }
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
    }
    
}

/**
 * Countries.java
 *
 * Created on 21. 3. 2015, 0:49:47 by burgetr
 */
package org.fit.layout.eswc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * A database of countries and their URIs.
 *  
 * @author burgetr
 */
public class Countries
{
    private static Map<String, String> countries;
    
    static {
        try
        {
            countries = new HashMap<String, String>();
            BufferedReader is = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("countries_all.csv")));
            String line;
            while ((line = is.readLine()) != null)
            {
                String s[] = line.split(",");
                if (s.length == 3)
                {
                    countries.put(s[1].toLowerCase(), s[0]);
                    countries.put(s[2].toLowerCase(), s[0]);
                }
            }
        } catch (IOException e)
        {
            System.err.println("Load failed: " + e.getMessage());
        }
    }
    
    public static String getCountryUri(String name)
    {
        return countries.get(name.toLowerCase());
    }
    
    public static Vector<String> getCountryNames(String s)
    {
        Vector<String> ret = new Vector<String>();
        String[] words = s.toLowerCase().split("\\W+");
        for (String w : words)
        {
            if (w.equals("italy"))
                System.out.println("jo!");
            if (countries.containsKey(w))
                ret.add(w);
        }
        return ret;
    }
    
}

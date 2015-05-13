/**
 * IndexFile.java
 *
 * Created on 26. 4. 2015, 22:12:29 by burgetr
 */
package org.fit.layout.eswc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 * Ceur index page representation.
 * 
 * @author burgetr
 */
public class IndexFile
{
    private static Map<Integer, List<Integer>> related;
    private static Map<Integer, List<String>> editors;
    private static Map<Integer, String> titles;
    private static Map<Integer, Date> dates;
    private static CSVConvertor csv;
    
    static {
        try
        {
            loadRelated();
            loadTitles();
            loadEditors();
            loadCsv();
        } catch (IOException e)
        {
            System.err.println("CSV load failed: " + e.getMessage());
        }
    }

    private static void loadRelated() throws IOException
    {
        //read the related workshops from related.csv
        related = new HashMap<Integer, List<Integer>>();
        BufferedReader is = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("related.csv")));
        String line;
        while ((line = is.readLine()) != null)
        {
            String s[] = line.split("\\s*,\\s*");
            if (s.length == 2)
            {
                final int n1 = parseVol(s[0]);
                final int n2 = parseVol(s[1]);
                List<Integer> rel = related.get(n1);
                if (rel == null)
                {
                    rel = new Vector<Integer>(5);
                    rel.add(n2);
                    related.put(n1, rel);
                }
                else
                    rel.add(n2);
            }
        }
        is.close();
    }

    private static void loadEditors() throws IOException
    {
        //read the related workshops from related.csv
        editors = new HashMap<Integer, List<String>>();
        BufferedReader is = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("editors.csv")));
        String line;
        while ((line = is.readLine()) != null)
        {
            String s[] = line.split(";;");
            if (s.length == 2)
            {
                final int n1 = parseVol(s[0]);
                final String name = s[1];
                List<String> rel = editors.get(n1);
                if (rel == null)
                {
                    rel = new Vector<String>(5);
                    rel.add(name);
                    editors.put(n1, rel);
                }
                else
                    rel.add(name);
            }
        }
        is.close();
    }

    private static void loadTitles() throws IOException
    {
        //read the titles and dates from titles.csv
        titles = new HashMap<Integer, String>();
        dates = new HashMap<Integer, Date>();
        BufferedReader is = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("titles.csv")));
        String line;
        while ((line = is.readLine()) != null)
        {
            String s[] = line.split("\\s*;;\\s*");
            if (s.length == 3)
            {
                int vol = parseVol(s[0]);
                
                String title = s[1];
                if (title.endsWith("."))
                    title = title.substring(0, title.length() - 1);
                titles.put(vol, title);
                
                DateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                try
                {
                    Date pubdate = df.parse(s[2]);
                    dates.put(vol, pubdate);
                } catch (ParseException e)
                {
                    System.err.println("Couldn't decode " + s[2] + ": " + e.getMessage());
                }
            }
            else
                System.out.println("Something wrong in titles.csv?");
        }
        is.close();
    }
    
    private static void loadCsv() throws IOException
    {
        csv = new CSVConvertor();
        BufferedReader in = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("titles_long.csv")));
        csv.parseIndex(in);
        in.close();
    }

    public static int parseVol(String vol)
    {
        return Integer.parseInt(vol.substring(4)); //remove Vol-
    }
    
    public static List<Integer> getRelated(int vol)
    {
        return related.get(vol);
    }
    
    public static String getTitle(int vol)
    {
        return titles.get(vol);
    }
    
    public static Date getPubDate(int vol)
    {
        return dates.get(vol);
    }
    
    public static List<String> getEditorNames(int vol)
    {
        return editors.get(vol);
    }
    
    public static String[] getDates(int vol)
    {
        String[] ret = new String[2];
        List<String> slist = csv.getData(vol, "segm:istartdate");
        ret[0] = (slist.size() > 0) ? unquote(slist.get(0)) : null;
        List<String> elist = csv.getData(vol, "segm:ienddate");
        ret[1] = (elist.size() > 0) ? unquote(elist.get(0)) : null;
        return ret;
    }
    
    public static Set<Event> getShortNames(int vol)
    {
        HashSet<Event> ret = new HashSet<Event>();
        List<String> snames = csv.getData(vol, "segm:ishort");
        for (String s : snames)
        {
            String[] parts = unquote(s).split(":");
            Event e = new Event(Integer.parseInt(parts[1]), parts[0]);
            ret.add(e);
        }
        return ret;
    }
    
    public static String getColoc(int vol)
    {
        List<String> cnames = csv.getData(vol, "segm:icoloc");
        if (cnames.size() > 0)
            return unquote(cnames.get(0));
        else
            return null;
    }
    
    public static void dumpIndex(String file)
    {
        csv.dump(file);
    }
    
    private static String unquote(String src)
    {
        return src.replaceAll("^\"", "").replaceAll("\"$", "");
    }
}

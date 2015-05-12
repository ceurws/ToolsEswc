/**
 * CSVConvertor.java
 *
 * Created on 7. 5. 2015, 13:42:48 by burgetr
 */
package org.fit.layout.eswc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import org.fit.layout.classify.taggers.DateTagger;

/**
 * 
 * @author burgetr
 */
public class CSVConvertor
{
    private static Map<String, Map<String, String>> idata;
    
    static {
        idata = new HashMap<String, Map<String,String>>();
    }
    
    private static void store(String s, String p, String o)
    {
        Map<String, String> vals = idata.get(s);
        if (vals == null)
        {
            vals = new HashMap<String, String>();
            idata.put(s, vals);
        }
        vals.put(p, o);
    }
    
    private static void out(String s, String p, String o)
    {
        //System.out.println(s + " " + p + " \"" + o + "\" .");
        store(s, p, "\"" + o + "\"");
    }
    
    private static void outurl(String s, String p, String o)
    {
        //System.out.println(s + " " + p + " <" + o + "> .");
        store(s, p, "<" + o + ">");
    }
    
    private static void dump()
    {
        for (Map.Entry<String, Map<String, String>> ventry : idata.entrySet())
        {
            for (Map.Entry<String, String> dentry : ventry.getValue().entrySet())
            {
                System.out.println(ventry.getKey() + " " + dentry.getKey() + " " + dentry.getValue() + " .");
            }
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
            BufferedReader in = new BufferedReader(new FileReader("/home/burgetr/git/ToolsEswc/awk/titles.csv"));
            
            String line;
            while ((line = in.readLine()) != null)
            {
                //volume title
                String[] f = line.split(";;");
                out(f[0], "segm:ititle", f[1]);
                
                //date of publication
                DateFormat srcf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                DateFormat dfmt = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                try
                {
                    Date pubdate = srcf.parse(f[2]);
                    out(f[0], "segm:isubmitted", dfmt.format(pubdate));
                } catch (ParseException e)
                {
                    System.err.println("Couldn't decode " + f[2] + ": " + e.getMessage());
                }

                //proceedings text 
                out(f[0], "segm:iproceedings", f[3]);
                //date and place text
                out(f[0], "segm:idateplace", f[4]);

                //start-end date
                DateTagger dt = new DateTagger();
                List<Date> dates = dt.extractDates(f[4]);
                if (dates.size() == 1)
                {
                    out(f[0], "segm:istartdate", dfmt.format(dates.get(0)));
                    out(f[0], "segm:ienddate", dfmt.format(dates.get(0)));
                }
                else if (dates.size() == 2)
                {
                    out(f[0], "segm:istartdate", dfmt.format(dates.get(0)));
                    out(f[0], "segm:ienddate", dfmt.format(dates.get(1)));
                }
                else
                    System.err.println("Strange number of date values: " + f[4]);
                
                //country
                CountriesTagger ct = new CountriesTagger();
                List<String> countries = ct.extract(f[4]);
                if (countries.size() >= 1)
                {
                    String uri = Countries.getCountryUri(countries.get(countries.size() - 1)); //use the last country
                    outurl(f[0], "segm:country", uri);
                }

                //short titles
                SubtitleParser sp = new SubtitleParser(f[3], new Vector<String>());
                for (SubtitleParser.Event ev : sp.getWorkshops())
                {
                    out(f[0], "segm:ishort", ev.sname + ":" + ev.order);
                }
                SubtitleParser.Event coloc = sp.getColocEvent();
                if (coloc != null)
                    out(f[0], "segm:icoloc", coloc.sname);
                
            }
            
            in.close();
            dump();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}

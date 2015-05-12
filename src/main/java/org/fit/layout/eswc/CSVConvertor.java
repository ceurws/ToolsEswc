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
import java.io.PrintWriter;
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
    
    private static void dump(String destfile)
    {
        try
        {
            PrintWriter w = new PrintWriter(destfile);
            for (Map.Entry<String, Map<String, String>> ventry : idata.entrySet())
            {
                for (Map.Entry<String, String> dentry : ventry.getValue().entrySet())
                {
                    w.println(ventry.getKey() + " " + dentry.getKey() + " " + dentry.getValue() + " .");
                }
            }
            w.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    
    private static void parseIndex(BufferedReader in) throws IOException
    {
        String line;
        while ((line = in.readLine()) != null)
        {
            //volume title
            String[] f = line.split(";;");
            out(f[0], "segm:ititle", f[1]);
            System.err.println(f[0]);
            
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
                int o = (ev.order > 0) ? ev.order : 1;
                out(f[0], "segm:ishort", ev.sname + ":" + o);
            }
            SubtitleParser.Event coloc = sp.getColocEvent();
            if (coloc != null)
                out(f[0], "segm:icoloc", coloc.sname);
            
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.err.println("Usage: CSVConvertor <input_file.csv> <outfile.n3>");
            System.exit(1);
        }
        
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(args[0]));
            parseIndex(in);
            in.close();
            dump(args[1]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

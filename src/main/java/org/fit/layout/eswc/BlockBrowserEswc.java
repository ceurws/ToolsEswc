/**
 * BlockBrowserTest.java
 *
 * Created on 24. 2. 2015, 9:21:16 by burgetr
 */

package org.fit.layout.eswc;

import java.awt.EventQueue;
import java.net.URL;

import javax.swing.JFrame;

import org.fit.layout.tools.BlockBrowser;

/**
 * 
 * @author burgetr
 */
public class BlockBrowserEswc extends BlockBrowser
{

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    browser = new BlockBrowser();
                    browser.setLoadImages(false);
                    JFrame main = browser.getMainWindow();
                    //main.setSize(1000,600);
                    //main.setMinimumSize(new Dimension(1200, 600));
                    //main.setSize(1500,600);
                    main.setSize(1600,1000);
                    browser.initPlugins();
                    main.setVisible(true);
                    
                    String localpath = "file://" + System.getProperty("user.home");
                    localpath += "/git/TestingLayout";
            
                    
                    /* CEUR */
                    URL url = new URL(localpath + "/test/ceur/volumes/Vol-1317.html");
                    
                    browser.setLocation(url.toString());
                        
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

}

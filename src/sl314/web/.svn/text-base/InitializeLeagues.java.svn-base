package sl314.web;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;
// Support classes
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
// Model classes
import sl314.model.League;
import java.util.List;
import java.util.LinkedList;

public class InitializeLeagues implements ServletContextListener {
    
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        List leagueList = new LinkedList();
        String leaguesFile = context.getInitParameter("leagues-file");
        InputStream is = null;
        BufferedReader reader = null;
        
        try {
            is = context.getResourceAsStream(leaguesFile);
            reader = new BufferedReader(new InputStreamReader(is));
            String record;
            
            // Read every record (one per line)
            while ( (record = reader.readLine()) != null ) {
                String[] fields = record.split("\t");
                
                // Extract the data fields for the record
                int year = Integer.parseInt(fields[0]);
                String season = fields[1];
                String title = fields[2];
                
                // Add the new League item to the list
                League item = new League(year, season, title);
                leagueList.add(item);
            }
            
            context.setAttribute("leagueList", leagueList);
            
            context.log("The league list has been loaded.");
            
        } catch (Exception e) {
            context.log("Exception occured while processing the leagues file.", e);
            
        } finally {
            if ( is != null ) {
                try { is.close(); } catch (Exception e) {}
            }
            if ( reader != null ) {
                try { reader.close(); } catch (Exception e) {}
            }
        }
        
    } // END of contextInitialized
    
    public void contextDestroyed(ServletContextEvent event) {
        // do nothing
    }
    
} // END of InitializeLeagues class

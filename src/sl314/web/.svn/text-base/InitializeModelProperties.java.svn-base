package sl314.web;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;

public class InitializeModelProperties implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        String dataDirectory = context.getInitParameter("data-directory");
        
        if ( dataDirectory != null ) {
            // Store this directory as a System property
            context.setAttribute("sl314.model.dataDirectory", dataDirectory);
            context.log("The dataDirectory attribute has been set.");            
        } else {
            context.log("The 'data-directory' context parameter was not set.");
        }
        
    } // END of contextInitialized
    
    public void contextDestroyed(ServletContextEvent event) {
        // do nothing
    }    
}

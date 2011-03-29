package sl314.view;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Support classes
import java.io.IOException;
import java.io.PrintWriter;
// Model classes
import sl314.model.League;
import java.util.List;
import java.util.Iterator;

public class ListLeaguesServlet extends HttpServlet {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 5592577235919233757L;
    
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {
        
        // Set page title
        String pageTitle = "Duke's Soccer League: List Leagues";
        
        // Retrieve the list of leagues from the context-scope
        ServletContext context = getServletContext();
        List leagueList = (List) context.getAttribute("leagueList");
        
        // Specify the content type is HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Generate the HTML response
        out.println("<html>");
        out.println("<head>");
        out.println("  <title>" + pageTitle + "</title>");
        out.println("</head>");
        out.println("<body bgcolor='white'>");
        
        // Generate page heading
        out.println("<!-- Page Heading -->");
        out.println("<table border='1' cellpadding='5' cellspacing='0' width='400'>");
        out.println("<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>");
        out.println("  <td><h3>" + pageTitle + "</h3></td>");
        out.println("</tr>");
        out.println("</table>");
        
        // Generate main body
        out.println("<p>");
        out.println("The set of soccer leagues are:");
        out.println("</p>");
        
        out.println("<ul>");
        Iterator<League> items = leagueList.iterator();
        while ( items.hasNext() ) {
            League league = (League) items.next();
            out.println("  <li>" + league.getTitle() + "</li>");
        }
        out.println("</ul>");
        
        out.println("</body>");
        out.println("</html>");
    } // END of doGet method
}// END of ListLeaguesServlet class

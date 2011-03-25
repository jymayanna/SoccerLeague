package sl314.view;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Support classes
import java.io.IOException;
import java.io.PrintWriter;
// Model classes
import java.util.List;
import java.util.Iterator;

public class ErrorPageServlet extends HttpServlet {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 5960707335573960976L;

	public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {
        generateView(request, response);
    }
    
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {
        generateView(request, response);
    }
    
    public void generateView(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {
        
        // Set page title
        String pageTitle = "Duke's Soccer League: Error Page";
        
        // Retrieve the errorMsgs from the request-scope
        List errorMsgs = (List) request.getAttribute("errorMsgs");
        
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
        out.println("<tr bgcolor='red' align='center' valign='middle' height='20'>");
        out.println("  <td><h3>" + pageTitle + "</h3></td>");
        out.println("</tr>");
        out.println("</table>");
        
        // Generate main body
        out.println("<p>");
        out.println("<font color='red'>Please correct the following errors:");
        out.println("<ul>");
        Iterator items = errorMsgs.iterator();
        while ( items.hasNext() ) {
            String message = (String) items.next();
            out.println("  <li>" + message + "</li>");
        }
        out.println("</ul>");
        out.println("Back up and try again.");
        out.println("</font>");
        out.println("</p>");
        
        out.println("</body>");
        out.println("</html>");
    }
}

package sl314.view;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Support classes
import java.io.IOException;
import java.io.PrintWriter;
// Model classes
import sl314.model.League;
import sl314.model.Player;

public class ThankYouServlet extends HttpServlet {
    
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
        String pageTitle = "Duke's Soccer League: Registration: Thank You";
        
        // Retrieve the 'league' and 'player' from the request-scope
        League league = (League) request.getAttribute("league");
        Player player = (Player) request.getAttribute("player");
        
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
        
        // Present the main body
        out.println("<p>");
        out.print("Thank you, " + player.getName() + ", for register for the ");
        out.println("<i>" + league.getTitle() + "</i> league.");
        out.println("</p>");
        
        out.println("</body>");
        out.println("</html>");
    }
}

package sl314.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
// Support classes
import java.io.IOException;
import java.io.PrintWriter;
// Model classes
import sl314.model.RegisterService;
import sl314.model.League;
import sl314.model.Player;
import sl314.model.ObjectNotFoundException;
import java.util.List;
import java.util.LinkedList;


public class RegisterServlet extends HttpServlet {
    
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        
        // Keep a set of strings to record form processing errors.
        List errorMsgs = new LinkedList();
        // Store this set in the request scope, in case we need to
        // send the ErrorPage view.
        request.setAttribute("errorMsgs", errorMsgs);
        
        try {
            
            // Retrieve form parameters.
            String season = request.getParameter("season").trim();
            String yearStr = request.getParameter("year").trim();
            String name = request.getParameter("name").trim();
            String address = request.getParameter("address").trim();
            String city = request.getParameter("city").trim();
            String province = request.getParameter("province").trim();
            String postalCode = request.getParameter("postalCode").trim();
            String division = request.getParameter("division").trim();
            
            // Perform data conversions.
            int year = -1;
            try {
                year = Integer.parseInt(yearStr);
            } catch (NumberFormatException nfe) {
                errorMsgs.add("The 'year' field must be a positive integer.");
            }
            
            // Verify 'Select League' form fields
            if ( (year != -1) && ((year < 2000) || (year > 2010)) ) {
                errorMsgs.add("The 'year' field must within 2000 to 2010.");
            }
            if ( season.equals("UNKNOWN") ) {
                errorMsgs.add("Please select a league season.");
            }
            
            // Verify 'Enter Player Information' form fields
            if ( name.length() == 0 ) {
                errorMsgs.add("You must enter your full name.");
            }
            if (   (address.length() == 0)  || (city.length() == 0)
            || (province.length() == 0) || (postalCode.length() == 0) ) {
                errorMsgs.add("You must enter your full address.");
            }
            
            // Verify 'Select Division' form fields
            if ( division.equals("UNKNOWN") ) {
                errorMsgs.add("You must select a division.");
            }
            
            // Send the ErrorPage view if there were errors
            if ( ! errorMsgs.isEmpty() ) {
                RequestDispatcher view
                        = request.getRequestDispatcher("form.view");
                view.forward(request, response);
                return;
            }
            
            // Perform business logic
            String dataDirectory = (String)getServletContext().getAttribute("sl314.model.dataDirectory");
            RegisterService registerSvc = new RegisterService(dataDirectory);
            // Retrieve the league
            League league = registerSvc.getLeague(year, season);
            // Update the player info
            Player player = registerSvc.getPlayer(name);
            player.setAddress(address);
            player.setCity(city);
            player.setProvince(province);
            player.setPostalCode(postalCode);
            // Perform the registration
            registerSvc.register(league, player, division);
            
            // Store the league and player objects in the request-scope
            request.setAttribute("league", league);
            request.setAttribute("player", player);
            
            // Send the Success view
            RequestDispatcher view
                    = request.getRequestDispatcher("thank_you.view");
            view.forward(request, response);
            return;
            
            // Handle business exceptions
        } catch (ObjectNotFoundException onfe) {
            errorMsgs.add("The league you selected does not yet exist."
                    + " Please select another.");
            RequestDispatcher view
                    = request.getRequestDispatcher("form.view");
            view.forward(request, response);
            
            // Handle any unusual exceptions
        } catch (RuntimeException e) {
            errorMsgs.add(e.getMessage());
            RequestDispatcher view
                    = request.getRequestDispatcher("form.view");
            view.forward(request, response);
            
            // Log stack trace
            e.printStackTrace(System.err);
            
        } // END of try-catch block
        
    } // END of doPost method
    
} // END of RegisterServlet class

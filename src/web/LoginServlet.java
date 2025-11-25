package web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

// A basic Java Servlet to demo user login handling via POST request
public class LoginServlet extends HttpServlet {

    // This method handles POST requests from the client
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        // Read user input parameters 'email' and 'password' from the request
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Set the response type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Begin HTML response output
        out.println("<html><body>");
        
        // Simple login check: if matched, login successful; else, failed
        if("admin@example.com".equals(email) && "admin123".equals(password)) {
            out.println("<h2>Login successful!</h2>");
        } else {
            out.println("<h2>Login failed. Please try again.</h2>");
        }

        // End HTML output
        out.println("</body></html>");
    }
}

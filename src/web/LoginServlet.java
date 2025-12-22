package web;

import dao.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("username");
        String password = request.getParameter("password");

        // basic server-side validation
        if (email == null || email.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {

            request.setAttribute("error", "Email and password are required.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        try {
            UserDAO userDao = new UserDAO();
            User user = userDao.loginUser(email.trim(), password.trim());

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", user);
                session.setAttribute("userEmail", user.getEmail());
                session.setAttribute("userRole", user.getRole());

                response.sendRedirect("listRecipes");
            } else {
                request.setAttribute("error", "Invalid email or password.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Login failed due to server error.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}

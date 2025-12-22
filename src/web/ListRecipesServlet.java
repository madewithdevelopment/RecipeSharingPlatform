package web;

import dao.RecipeDAO;
import model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/listRecipes")
public class ListRecipesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // session protection
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("currentUser") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        RecipeDAO dao = new RecipeDAO();
        List<Recipe> list = dao.getAllRecipes();

        request.setAttribute("recipes", list);
        request.getRequestDispatcher("listRecipes.jsp").forward(request, response);
    }
}

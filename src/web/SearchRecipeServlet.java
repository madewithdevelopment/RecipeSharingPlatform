package web;

import dao.RecipeDAO;
import model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchRecipes")
public class SearchRecipeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("currentUser") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String keyword = request.getParameter("q");
        if (keyword == null) keyword = "";

        RecipeDAO dao = new RecipeDAO();
        List<Recipe> recipes;

        if (keyword.trim().isEmpty()) {
            recipes = dao.getAllRecipes();
        } else {
            recipes = dao.searchRecipesByTitle(keyword.trim());
        }

        request.setAttribute("recipes", recipes);
        request.setAttribute("keyword", keyword);
        request.getRequestDispatcher("listRecipes.jsp").forward(request, response);
    }
}

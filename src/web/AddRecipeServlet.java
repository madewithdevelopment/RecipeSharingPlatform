package web;

import dao.RecipeDAO;
import model.Recipe;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/addRecipe")
public class AddRecipeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // session protection
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("currentUser") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String title = request.getParameter("title");
        String ingredients = request.getParameter("ingredients");
        String steps = request.getParameter("steps");

        // validation
        if (title == null || title.trim().isEmpty()
                || ingredients == null || ingredients.trim().isEmpty()
                || steps == null || steps.trim().isEmpty()) {

            request.setAttribute("error", "Title, ingredients and steps are required.");
            request.getRequestDispatcher("addRecipe.jsp").forward(request, response);
            return;
        }

        User currentUser = (User) session.getAttribute("currentUser");
        int userId = (currentUser != null) ? currentUser.getUserId() : 0;

        Recipe recipe = new Recipe(
                0,
                title.trim(),
                ingredients.trim(),
                steps.trim(),
                userId
        );

        RecipeDAO dao = new RecipeDAO();
        boolean ok = dao.addRecipe(recipe);

        if (ok) {
            response.sendRedirect("listRecipes");
        } else {
            request.setAttribute("error", "Could not save recipe. Try again.");
            request.getRequestDispatcher("addRecipe.jsp").forward(request, response);
        }
    }
}

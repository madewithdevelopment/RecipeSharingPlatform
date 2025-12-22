package dao;

import model.Recipe;
import java.sql.*;
import java.util.*;

public class RecipeDAO {
    private Connection connection;

    public RecipeDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    // Add new recipe to DB
    public boolean addRecipe(Recipe recipe) {
        String query = "INSERT INTO recipes (title, ingredients, steps, user_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, recipe.getTitle());
            ps.setString(2, recipe.getIngredients());
            ps.setString(3, recipe.getSteps());
            ps.setInt(4, recipe.getUserId());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all recipes from DB
    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        String query = "SELECT * FROM recipes";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Recipe recipe = new Recipe(
                        rs.getInt("recipe_id"),
                        rs.getString("title"),
                        rs.getString("ingredients"),
                        rs.getString("steps"),
                        rs.getInt("user_id"));
                recipes.add(recipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipes;
    }

    // Search by title
    public List<Recipe> searchRecipesByTitle(String keyword) {
        List<Recipe> recipes = new ArrayList<>();
        String query = "SELECT * FROM recipes WHERE title LIKE ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, "%" + keyword + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Recipe recipe = new Recipe(
                            rs.getInt("recipe_id"),
                            rs.getString("title"),
                            rs.getString("ingredients"),
                            rs.getString("steps"),
                            rs.getInt("user_id"));
                    recipes.add(recipe);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipes;
    }
}

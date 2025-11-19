package model;

// Represents a recipe entity
public class Recipe {
    private int recipeId;
    private String title;
    private String ingredients;
    private String steps;
    private int userId;

    public Recipe(int recipeId, String title, String ingredients, String steps, int userId) {
        this.recipeId = recipeId;
        this.title = title;
        this.ingredients = ingredients;
        this.steps = steps;
        this.userId = userId;
    }

    // Getters
    public int getRecipeId() { return recipeId; }
    public String getTitle() { return title; }
    public String getIngredients() { return ingredients; }
    public String getSteps() { return steps; }
    public int getUserId() { return userId; }
    
    // Setters
    public void setRecipeId(int recipeId) { this.recipeId = recipeId; }
    public void setTitle(String title) { this.title = title; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }
    public void setSteps(String steps) { this.steps = steps; }
    public void setUserId(int userId) { this.userId = userId; }
}

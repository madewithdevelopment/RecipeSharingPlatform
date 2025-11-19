package ui;

import dao.UserDAO;
import dao.RecipeDAO;
import model.User;
import model.Recipe;
import java.util.*;

public class MainUI {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        RecipeDAO recipeDAO = new RecipeDAO();
        Scanner scanner = new Scanner(System.in);
        User loggedInUser = null; // Stores currently logged-in user

        while (true) {
            System.out.println("\n--- Recipe Sharing Platform Menu ---");
            System.out.println("1. Register a new user");
            System.out.println("2. View all users");
            System.out.println("3. Exit");
            System.out.println("4. Add a recipe");
            System.out.println("5. View all recipes");
            System.out.println("6. Login");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Register a new user
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter role (user/admin): ");
                    String role = scanner.nextLine();

                    User user = new User(0, name, email, password, role);
                    boolean created = userDAO.createUser(user);
                    if (created) {
                        System.out.println("User registered successfully!");
                    } else {
                        System.out.println("Registration failed.");
                    }
                    break;

                case 2:
                    // View all users
                    List<User> users = userDAO.getAllUsers();
                    System.out.println("\nList of users:");
                    for (User u : users) {
                        System.out.println(u.getUserId() + " | "
                            + u.getName() + " | "
                            + u.getEmail() + " | "
                            + u.getRole());
                    }
                    break;

                case 3:
                    System.out.println("Exiting. Thank you!");
                    scanner.close();
                    System.exit(0);
                    break;

                case 4:
                    // Add recipe: Only if logged in!
                    if (loggedInUser != null) {
                        System.out.print("Enter recipe title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter ingredients: ");
                        String ingredients = scanner.nextLine();
                        System.out.print("Enter steps: ");
                        String steps = scanner.nextLine();

                        Recipe recipe = new Recipe(0, title, ingredients, steps, loggedInUser.getUserId());
                        boolean added = recipeDAO.addRecipe(recipe);
                        if (added) {
                            System.out.println("Recipe added successfully!");
                        } else {
                            System.out.println("Error adding recipe.");
                        }
                    } else {
                        System.out.println("Please login first to add a recipe.");
                    }
                    break;

                case 5:
                    // View all recipes
                    List<Recipe> recipes = recipeDAO.getAllRecipes();
                    System.out.println("\nList of recipes:");
                    for (Recipe r : recipes) {
                        System.out.println(
                            r.getRecipeId() + " | " + r.getTitle() + " | by User " + r.getUserId() +
                            "\nIngredients: " + r.getIngredients() +
                            "\nSteps: " + r.getSteps() + "\n"
                        );
                    }
                    break;

                case 6:
                    // Login
                    System.out.print("Enter your email: ");
                    String loginEmail = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String loginPassword = scanner.nextLine();
                    User userFound = userDAO.loginUser(loginEmail, loginPassword);
                    if (userFound != null) {
                        loggedInUser = userFound;
                        System.out.println("Login successful! Welcome, " + userFound.getName() + " (" + userFound.getRole() + ")");
                        System.out.println("Your User ID: " + userFound.getUserId());
                    } else {
                        System.out.println("Login failed: Incorrect email or password.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid menu option.");
            }
        }
    }
}

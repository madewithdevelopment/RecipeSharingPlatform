package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Creates and provides a database connection for DAO classes
public class DatabaseConnection {
    // Connection details - update these as per your MySQL setup
    private static final String URL = "jdbc:mysql://localhost:3306/recipe_platform";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Ltpra007@";

    // Returns a Connection object to interact with the database
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish and return connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Database connected!");
        } catch (ClassNotFoundException | SQLException e) {
            // Show error message if connection fails
            e.printStackTrace();
        }
        return connection;
    }
}

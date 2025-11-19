package ui;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/recipe_platform";
        String username = "root"; // YOUR MySQL Username
        String password = "Ltpra007@"; // YOUR MySQL Password

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Loads JDBC Driver
            Connection connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("Connection Success: Java is connected to MySQL!");
            } else {
                System.out.println("Connection Failed: Check credentials or database.");
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("Error connecting: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

# OnlineRecipeSharingPlatform

A desktop-based Java web application that enables users to share and manage recipes, register and log in securely, and review others' recipes. Built with Java (OOP), featuring JDBC connectivity with a MySQL backend database and servlets for web functionality.

## Features

- User Registration and Login (Servlet + Command Line)
- Add, View, and Manage Recipes
- Review & Rate Recipes
- Simple login form (HTML + Servlet)
- MySQL Database Integration
- Modular, Well-Commented Code

## Tech Stack

- Language: Java
- Web: Servlet API
- Database: MySQL
- Connectivity: JDBC
- IDE: VS Code (recommended)
- Project Type: Web application

## Project Structure

RecipeSharingPlatform/
├── src/
│ ├── model/ # Entity/model classes (User, Recipe, Review)
│ ├── dao/ # Data Access Objects (UserDAO, RecipeDAO, ReviewDAO)
│ ├── ui/ # Command-line menu, MainUI (entry point)
│ └── web/ # Servlet (LoginServlet.java)
├── lib/ # External libraries (e.g., mysql-connector .jar, servlet-api.jar)
├── build/ # Compiled classes (after javac)
├── web/ # HTML pages (login.html)
├── WEB-INF/
│ ├── web.xml
│ └── classes/
│ └── web/
│ └── LoginServlet.class
├── README.md # This documentation

text

## Database Setup

1. Install MySQL and start your MySQL server.
2. Set credentials in:
src/dao/DatabaseConnection.java

text
undefined
private static final String URL = "jdbc:mysql://localhost:3306/recipe_platform";
private static final String USER = "root";
private static final String PASSWORD = "YourPassword";

text
3. Create tables using provided SQL (users, recipes, reviews).
4. Place MySQL connector JAR in `/lib/` folder.

## Running the Project

### Option 1: Run via Command Line (Console App)

- Compile:
javac -cp "lib/mysql-connector-j-9.5.0.jar" src/model/.java src/dao/.java src/ui/*.java

text
- Run:
java -cp "lib/mysql-connector-j-9.5.0.jar;src" ui.MainUI

text

### Option 2: Compile and Run Servlet (Login Example)

**1. Compile the servlet:**
javac -cp "lib/servlet-api.jar" -d build/ src/web/LoginServlet.java

text

**2. Copy `LoginServlet.class` to:**
apache-tomcat-9.0.112/webapps/RecipeSharingPlatformWeb/WEB-INF/classes/web/

text

**3. Start Tomcat and open in browser:**
http://localhost:8080/RecipeSharingPlatformWeb/login.html

text

### Sample HTML login form
<form method="POST" action="login"> Username: <input type="text" name="username" /><br> Password: <input type="password" name="password" /><br> <input type="submit" value="Login" /> </form> ```
Java Servlet Example (LoginServlet.java)
<details> <summary>LoginServlet.java (click to expand)</summary>
text
package web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if ("admin".equals(username) && "pass123".equals(password)) {
            out.println("<h2>Login Success! Welcome, " + username + ".</h2>");
        } else {
            out.println("<h2>Login Failed. Invalid credentials.</h2>");
        }
        out.close();
    }
}
</details>
Contributors
Prachi Mishra
Priya Dixit
Sweta Jha

License
This project is for academic purposes under Galgotias University.

For questions or suggestions, please create an issue or submit a pull request!

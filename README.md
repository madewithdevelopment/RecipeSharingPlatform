# Online Recipe Sharing Platform

A desktop-based Java application that enables users to share and manage recipes, register and log in securely, and review others' recipes. Built with Java (OOP), featuring JDBC connectivity with a MySQL backend database.

---

## Features

- User Registration and Login: Easily create accounts and log in.
- Add, View, and Manage Recipes: Share your favorite recipes and browse others.
- Review & Rate Recipes: Contribute feedback and ratings to help others.
- Console Menu (Java): Simple, stepwise interaction via command-line.
- MySQL Database Integration: Persistent storage for users, recipes, and reviews.
- Modular, Well-Commented Code: Structured for learning and extension.

---

## Tech Stack

- Language: Java
- Database: MySQL
- Connectivity: JDBC
- IDE: VS Code (recommended)
- Project Type: Console application

---

## Project Structure

Online-Recipe-Sharing-Platform/
├── src/
│ ├── model/ # Entity/model classes (User, Recipe, Review)
│ ├── dao/ # Data Access Objects (UserDAO, RecipeDAO, ReviewDAO)
│ ├── ui/ # User menu, MainUI (entry point)
│ └── service/ # Business logic/services (optional)
├── lib/ # External libraries (e.g., MySQL connector .jar)
├── README.md # Project documentation
├── screenshot/ # Application screenshots (for presentation)

text

---

## Database Setup

1. Install MySQL and start your MySQL server.
2. Set credentials in:
   - `src/dao/DatabaseConnection.java`:
     ```
     private static final String URL = "jdbc:mysql://localhost:3306/recipe_platform";
     private static final String USER = "root";
     private static final String PASSWORD = "YourPassword";
     ```
3. Create tables using provided SQL (users, recipes, reviews).
4. Place MySQL connector .jar in `/lib/` folder.

---

## Running the Project

### Option 1: Run from Source
- Clone the repository:
git clone https://github.com/madewithdevelopment/Online-Recipe-Sharing-Platform.git

text
- Open in VS Code or any Java IDE.
- Install dependencies and ensure Java and MySQL are installed.
- Run `MainUI.java` to launch the app:
javac -cp "lib/mysql-connector-java-x.x.x.jar" src/model/.java src/dao/.java src/ui/*.java
java -cp "lib/mysql-connector-java-x.x.x.jar;src" ui.MainUI

text

### Option 2: Compile and Run via Terminal
javac -d out src/**/*.java
java -cp "lib/mysql-connector-java-x.x.x.jar;out" ui.MainUI


## Contributors

Prachi Mishra 
Priya Dixit 
Sweta Jha 


## License

This project is for academic purposes under Galgotias University .

---

*For questions or suggestions, please create an issue or submit a pull request!*

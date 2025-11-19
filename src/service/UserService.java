package service;

import dao.UserDAO;

// Service layer - place for any business logic related to users
public class UserService {
    private UserDAO userDAO; // Helper object to interact with DAO

    public UserService() {
        userDAO = new UserDAO(); // Initialize the user DAO
    }

    // Future: Add service layer functions here to handle business logic
}


package services;

import database.DBQueries;
import database.DBConnection;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserServices {

    /**
     * Registers a new user in the database.
     *
     * @param user The User object containing the registration details.
     * @return true if registration is successful, false otherwise.
     */
    public boolean registerUser(User user) {
        try (Connection con = DBConnection.connectDB()) {
            PreparedStatement ps = con.prepareStatement(DBQueries.insertUser);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getRole());

            int result = ps.executeUpdate();
            System.out.println("Rows affected: " + result);
            return result > 0;
        } catch (Exception e) {
            System.err.println("Error during user registration: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Main method to test the functionality of UserServices.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        UserServices userServices = new UserServices();

        // Create a sample user for testing
        User testUser = new User();
        testUser.setName("John Doe");
        testUser.setEmail("john.doe@example.com");
        testUser.setGender("M");
        testUser.setPassword("password123");
        testUser.setRole("student");

        // Test the registerUser method
        boolean isRegistered = userServices.registerUser(testUser);
        if (isRegistered) {
            System.out.println("User registration successful!");
        } else {
            System.out.println("User registration failed.");
        }
    }
}

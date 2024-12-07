package controller;

import models.User;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserServices userServices = new UserServices();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data from the request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        // Validate required fields
        if (name == null || email == null || gender == null || password == null || role == null) {
            response.getWriter().println("<h3>All fields are required! <a href='register.jsp'>Try again</a></h3>");
            return;
        }

        // Create a new User object
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setGender(gender);
        user.setPassword(password);
        user.setRole(role);

        // Call the UserServices to register the user
        boolean isRegistered = userServices.registerUser(user);

        // Handle the response
        if (isRegistered) {
            response.getWriter().println("<h3>Registration successful! <a href='login.jsp'>Login here</a></h3>");
        } else {
            response.getWriter().println("<h3>Registration failed. <a href='register.jsp'>Try again</a></h3>");
        }
    }
}

package controller;

import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserServices userServices = new UserServices();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data from the request
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        response.setContentType("text/html");

        // Validate email and password fields
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            response.getWriter().println("<script type='text/javascript'>");
            response.getWriter().println("alert('Email and password are required!');");
            response.getWriter().println("window.location.href = 'index.html';");
            response.getWriter().println("</script>");
            return;
        }

        // Authenticate user
        boolean isAuthenticated = userServices.login(email, password);

        if (isAuthenticated) {

            response.getWriter().println("<script type='text/javascript'>");
            response.getWriter().println("alert('Login Successful!');");
            response.getWriter().println("window.location.href = 'dashboard.html';"); // Replace with your dashboard page
            response.getWriter().println("</script>");
        } else {
            // Redirect back to login page with an error message
            response.getWriter().println("<script type='text/javascript'>");
            response.getWriter().println("alert('Invalid email or password!');");
            response.getWriter().println("window.location.href = 'index.html';");
            response.getWriter().println("</script>");
        }
    }
}

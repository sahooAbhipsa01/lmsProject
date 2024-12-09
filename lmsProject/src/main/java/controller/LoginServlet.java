package controller;

import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserServices userServices = new UserServices();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Retrieve email and password from request
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate email and password inputs
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            response.getWriter().println("<script type='text/javascript'>");
            response.getWriter().println("alert('Email and password are required!');");
            response.getWriter().println("window.location.href = 'index.html';"); // Redirect back to login page
            response.getWriter().println("</script>");
            return;
        }

         int currentUserId=userServices.login(email, password);
          User user=userServices.getUserById(currentUserId);
          System.out.println(user);
          if(currentUserId != -1) {
        	  HttpSession httpSession=request.getSession();
        	  httpSession.setAttribute("loggedInUserId", currentUserId);
        	  httpSession.setAttribute("user", user);
        	  
        	  
        	  if("student".equalsIgnoreCase(user.getRole()))
        		  response.sendRedirect("student_dashboard.jsp");
        	  
        	  if("trainer".equalsIgnoreCase(user.getRole()))
        		  response.sendRedirect("trainer_dashboard.jsp");
          }else {
        	  response.sendRedirect("index.html");
          }
        
    }
}

package controller;

import services.EnrollmentServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/enroll")
public class EnrollmentServlet extends HttpServlet {

    private final EnrollmentServices enrollmentService = new EnrollmentServices();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve data from the form
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int courseId = Integer.parseInt(request.getParameter("courseId"));

        // Attempt to enroll the student in the course
        enrollmentService.enrollStudentInCourse(studentId, courseId);

        // Simple redirect to dashboard
        response.sendRedirect("dashboard.html");
    }
}

package services;

import database.DBConnection;
import database.DBQueries;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class EnrollmentServices {

	public boolean enrollStudentInCourse(int studentId, int courseId) {
		String query = DBQueries.insertEnrollments;

		try (Connection con = DBConnection.connectDB(); PreparedStatement ps = con.prepareStatement(query)) {

			ps.setInt(1, studentId);
			ps.setInt(2, courseId);

			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}

package database;

public class DBQueries {
	//users table queries
	public static final String insertUser = "INSERT INTO users (name, email, gender, password, role) VALUES (?, ?, ?, ?, ?)";
    public static final String getUserEmailAndPassword = "SELECT * FROM users WHERE email = ? AND password = ?";
    public static final String getUserByUserId = "SELECT * FROM users WHERE user_id = ?";
    public static final String getAllUsers = "SELECT * FROM users";
    public static final String deleteUser = "DELETE FROM users WHERE id = ?";
    
    
    //courses table queries
    public static final String insertCourse = "INSERT INTO courses (name, instructor_id) VALUES (?, ?)";
    public static final String getCourseByCourseId = "SELECT * FROM courses WHERE course_id = ?";
    public static final String getAllCourses = "SELECT * FROM courses";
    public static final String updateCoursesByNameAndId = "UPDATE courses SET name = ? WHERE course_id = ?";
    public static final String deleteCourseById = "DELETE FROM courses WHERE course_id = ?";
    
    //Enrollment Queries
    public static final String insertEnrollments = "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)";
    public static final String deleteEnrollments = "DELETE FROM enrollments WHERE student_id = ? AND course_id = ?";
    public static final String getEnrollmentByStudentId = "SELECT * FROM enrollments WHERE student_id = ?";
    public static final String getEnrollmentByCourseid = "SELECT * FROM enrollments WHERE course_id = ?";
    
    //grade queries
    public static final String insertGrade = "INSERT INTO grades (student_id, course_id, grade) VALUES (?, ?, ?)";
    public static final String update_grade = "UPDATE grades SET grade = ? WHERE id = ?";
    public static final String getGradesByStudentId = "SELECT * FROM grades WHERE student_id = ?";
    public static final String getGradesByCourseId = "SELECT * FROM grades WHERE course_id = ?";
    
    //// Forum Queries
    public static final String insertForumMessgaes = "INSERT INTO forum_messages (user_id, message) VALUES (?, ?)";
    public static final String deleteForumMessages = "DELETE FROM forum_messages WHERE forumMessages_id = ?";
    public static final String getAllForumMessages = "SELECT * FROM forum_messages ORDER BY created_at DESC";

   

}

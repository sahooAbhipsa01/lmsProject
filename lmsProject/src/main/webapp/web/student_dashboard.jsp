<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.List" %>
	<%@ page import="models.Courses" %>
	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Dashboard|Student</title>
<link rel="stylesheet" href="css/studentstyles.css">
</head>
<body>
	<div class="container">
		<!-- Left Section -->
		<div class="left-section">
			<h1 class="heading-underline">
				Hello, <span id="studentName">${sessionScope.user.name}</span>!
			</h1>
			<p>Welcome to your dashboard. Here you can view your courses,
				grades, and participate in discussions.</p>
		</div>

		<!-- Right Section -->
		<div class="right-section">
			<div class="form-container">
				<!-- Enrolled Courses -->
				<h2>Your Courses</h2>
				<table>
					<thead>
						<tr>
							<th>Course Name</th>
							<th>Instructor</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody id="enrolledCourses">
						<!-- Example Row -->
						<tr>
							<td>Mathematics 101</td>
							<td>Dr. John Smith</td>
							<td>Enrolled</td>
							<td><button disabled>Enrolled</button></td>
						</tr>
					</tbody>
				</table>

				<!-- All Courses -->
				<h2>All Courses</h2>
				<table>
					<thead>
						<tr>
							<th>Course Name</th>
							<th>Instructor</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody id="suggestedCourses">
						<!-- Example Row -->
						<%
						List <Courses>allCourses=(List<Courses>)request.getAttribute("allCoursesList");
						if (allCourses != null && !allCourses.isEmpty()) {
						for(Courses cr:allCourses)
						
						{
							%>
							
							<tr>
							<td><%=cr.getName() %></td>
							<td><%=cr.getTrainerName() %></td>
							<td><button>Enroll</button></td>	
							</tr>
						<%
						}
						}else{
							%><tr><td colspan="3">No courses available</td></tr>
							<%
						}
							%>
						
						
				
						
					</tbody>
				</table>

				<!-- Grades -->
				<h2>Your Grades</h2>
				<table class="table-grades">
					<thead>
						<tr>
							<th>Course</th>
							<th>Grade</th>
						</tr>
					</thead>
					<tbody id="grades">
						<!-- Example Row -->
						<tr>
							<td>Mathematics 101</td>
							<td>A</td>
						</tr>
					</tbody>
				</table>

				<!-- Discussion Forum -->
				<h2>Discussion Forum</h2>
				<table>
					<thead>
						<tr>
							<th>Discussion Topic</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody id="discussionForum">
						<!-- Example Row -->
						<tr>
							<td>General Questions</td>
							<td>
								<button>Join Discussion</button>
								<button>Post</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>

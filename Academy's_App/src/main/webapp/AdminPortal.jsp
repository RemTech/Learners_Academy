<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin-Login</title>
</head>
<body>
<h1 align="center" id="header">Welcome to Learner's Academy Admin Portal</h1>
<h3>Please Select the options below to start.</h3>
<ol>
1 <a href="<%=request.getContextPath() %>/list-subject">List-Of-Subjects</a><br><br>
2. <a href="<%=request.getContextPath() %>/list-teachers">List-Of-Teachers</a><br><br>
3. <a href="<%=request.getContextPath() %>/list-classes">List-Of-Classes</a><br><br>
4. <a href="<%=request.getContextPath() %>/assign_classes">Assign-Classes-For-Subjects</a><br><br>
5. <a href="<%=request.getContextPath() %>/teacher_classes">Assign-A-Teacher-To-Classes</a><br><br>
6. <a href="<%=request.getContextPath() %>/student-class">Student-List</a><br><br>
7. <a href="<%=request.getContextPath() %>/teachers_class">Assign-Teachers-To-A-Class</a><br><br>
</ol>
</body>
</html>



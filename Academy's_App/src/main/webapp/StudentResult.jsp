<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student-Result Page</title>
</head>
<body>
<h1>The following data have been saved successfully into the database.</h1>

Student-ID: <%= request.getAttribute("Student-ID") %><br><br>
First-Name: <%= request.getAttribute("First-Name") %><br><br>
Last-Name: <%= request.getAttribute("Last-Name") %><br><br>
Age: <%= request.getAttribute("Age") %><br><br>
Gender: <%= request.getAttribute("Gender") %><br><br>
Class-ID: <%= request.getAttribute("Class-ID") %><br><br>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class-Report Page</title>
</head>
<body>
<h1>Class Report for the Searched Class</h1>
<!-- displays the results from DB here -->
Access : <%= request.getAttribute("access") %>
Class-Capacity: <%= request.getAttribute("capacity") %>
Class-Name:  <%= request.getAttribute("class_name") %>
Class-size:  <%= request.getAttribute("class_size") %>
Floor-Level: <%= request.getAttribute("floor_level") %>
Student: <%= request.getAttribute("student") %>
Subject: <%= request.getAttribute("subject") %>
Teachers: <%= request.getAttribute("teachers") %>

</body>
</html>
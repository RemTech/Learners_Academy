<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>StudentList</title>
</head>
<body>
<h3>Details Of Students Below</h3>
<form action="<%=request.getContextPath()%>/studentslist" method="post"></form>
 Class: <%= request.getAttribute("")%><br><br>
 Name:  <%= request.getAttribute("") %><br><br>
 Age:   <%= request.getAttribute("")%><br><br>
</body>
</html>
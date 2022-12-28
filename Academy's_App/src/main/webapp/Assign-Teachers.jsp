<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign-Teachers Page</title>
</head>
<body>
<h1>The following details have been saved successfully in the database</h1>

First-Name: <%=request.getAttribute("firstName") %><br><br>
Last-Name: <%=request.getAttribute("lastName") %><br><br>
Class-Name: <%=request.getAttribute("className") %><br><br>
Subject-Name: <%=request.getAttribute("subjectName") %><br><br>
Subject-Code: <%=request.getAttribute("subjectCode") %><br><br>
Age: <%=request.getAttribute("age") %><br><br>
Gender: <%=request.getAttribute("gender") %><br><br>
Class-ID: <%=request.getAttribute("Class_Id") %><br><br>
Qualification: <%=request.getAttribute("qualification") %><br><br>

</body>
</html>
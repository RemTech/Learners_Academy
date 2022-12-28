<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher Data Success Page</title>
</head>
<body>
<h1>The following details has been saved successfully </h1>
FirstName: <%=request.getAttribute("firstName") %><br><br>
LastName:<%=request.getAttribute("lastName") %><br><br>
Qualification: <%=request.getAttribute("qualification") %><br><br>
Age: <%=request.getAttribute("age") %><br><br>
Gender: <%=request.getAttribute("gender") %><br><br>
</body>
</html>
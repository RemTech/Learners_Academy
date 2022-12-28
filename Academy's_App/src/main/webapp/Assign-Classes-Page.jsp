<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Classes Success page</title>
</head>
<body>
 <h1>The following data have been saved successfully in the database</h1>
 
 Floor-Level:<%= request.getAttribute("Floor_Level") %><br><br>
 Class-Name:<%= request.getAttribute("ClassName") %><br><br>
 Capacity:<%= request.getAttribute("Capacity") %><br><br>
 Accessible:<%= request.getAttribute("Accessible") %><br><br>
 Subject-Name:<%= request.getAttribute("Subject-Name") %><br><br>
 Subject-Code:<%= request.getAttribute("Subject-Code") %><br><br>
 
</body>
</html>
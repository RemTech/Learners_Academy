<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Notification</title>
</head>
<body><h2 align="center">Notification page</h2>
   <%= request.getAttribute("SuccessMessage")%><br><br>                                    <!-- to rewrite this in the page -->
   <%= request.getAttribute("UnsuccessfulMessage") %><br><br>
</body>
</html>
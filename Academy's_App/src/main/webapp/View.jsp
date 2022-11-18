<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><h2>View.jsp</h2>
  Classes: <%= request.getAttribute("classes")%><br><br>
  Subjects <%= request.getAttribute("Subject") %><br><br>
</body>
</html>
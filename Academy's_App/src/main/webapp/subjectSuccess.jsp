<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject Success Page</title>
</head>
<body>
<h3>The Data Entered Below</h3>
 SuccessMessage: <%=request.getAttribute("SuccessMessage") %><br><br>
 <h3>The Data Entered Below</h3>
 SubjectName: <%=request.getAttribute("SubjectName") %><br><br>
 SubjectCode: <%=request.getAttribute("SubjectCode") %><br><br>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Saved-Classes</title>
</head>
<body>
 <h3>You have saved the data below</h3>
 Success-Message: <%=request.getAttribute("SuccessMessage") %><br><br>
 Class-Name: <%=request.getAttribute("ClassName") %><br><br>
 ClassCapacity: <%=request.getAttribute("ClassCapacity") %><br><br>
 Class-Accessibility: <%=request.getAttribute("ClassAccessibility") %><br><br>
 Class-size: <%=request.getAttribute("Class-size") %><br><br>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class Report Page</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/classReport" method="post">
 <!-- parameters for the form -->
 Class-Name : <input type=text name="className"/>
 <tr>
 <td>
 <input type="submit" value="Class-Report">
 </td>
 </tr>
</form>
</body>
</html>
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
<form action="<%=request.getContextPath()%>/studentslist" method="post">
 Class-ID: <input type="text"  name="classID"/> <br><br>
 First-Name:  <input type="text" name="firstName"/> <br><br>
 Last-Name:  <input type="text" name="lastName"/> <br><br>
 Age:  <input type="text" name="age"/> <br><br>
 <tr>
 <td> 
     <input type="submit" value="Search">
 </td>
 </tr>
 </form>
</body>
</html>
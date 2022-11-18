<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AssignClasses</title>
</head>
<body>
<h1 align="center"></h1>
<h3>Enter Class And Subject Below</h3>

<form action="<%=request.getContextPath()%>/classes" method="post">
 Class:  <input type="text" name="classes"/><br><br>
 Subject:<input type="text" name="subjects"/><br><br>
 <tr>
  <td>
       <input type="submit" value="Assign"/>
  </td>
 </tr>
</form>
</body>
</html>
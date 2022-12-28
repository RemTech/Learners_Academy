<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TeachersClass</title>
</head>
<body>
<h2 align="center">Assign Teachers To A Class For A Subject</h2>
<h3>Please details below </h3>

<form action="<%= request.getContextPath() %>/teachers-to-class" method="post">
 First-Name: <input type="text" name="firstName"><br><br>
 Last-Name:  <input type="text" name="lastName"><br><br>
 Class-Name: <input type="text" name="className"><br><br>
 Subject-Name:    <input type="text" name="subjectName"><br><br>
 Subject-Code:    <input type="text" name="subjectCode"><br><br>
 Age:    <input type="text" name="age"><br><br>
 Gender:    <input type="text" name="gender"><br><br>
 Class-ID:    <input type="text" name="class_id"><br><br>
 Qualification:    <input type="text" name="qualification"><br><br>
 <tr>
  <td>
   <input type="submit" value="Assign">
   </td>
 </tr>
</form>
</body>
</html>
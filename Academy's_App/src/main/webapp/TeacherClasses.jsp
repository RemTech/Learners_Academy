<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TeacherClasses</title>
</head>
<body>
<h3>Assign Teacher To Classes</h3>
<form action="<%=request.getContextPath()%>/teacher_classes" method="post">
 First-Name: <input type="text" name="classes"><br><br>
 Last-Name:  <input type="text" name="subjects"><br><br>
 Class-Name: <input type="text" name="subjects"><br><br>
 <tr>
  <td>
       <input type="submit" value="Assign"/>
  </td>
 </tr>
</form>
</body>
</html>
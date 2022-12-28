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

<form action="<%=request.getContextPath()%>/assigns-class" method="post">
  Floor_Level: <input type="text" name="floorLevel"/><br><br>
  Capacity:  <input type="text" name="capacity"/><br><br>
  Accessible:  <input type="text" name="accessible"/><br><br>
  ClassName:   <input type="text" name="classname"/><br><br>
  Class-Size:  <input type="text" name="class-size"/><br><br>
  Subject-Name:   <input type="text" name="subject-name"/><br><br>
  Subject-Code:   <input type="text" name="subject-code"/><br><br> 
 <tr>
  <td>
       <input type="submit" value="Assign"/>
  </td>
 </tr>
</form>
</body>
</html>
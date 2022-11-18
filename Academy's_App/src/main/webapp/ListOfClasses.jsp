<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List-Of-Classes</title>
</head>
<body>
<h1 align="center">Welcome to Class Setup Page</h1>
 <h3>You can setup the list of classes by entering the relevant information below</h3>
 <form action="<%= request.getContextPath() %>/list-classes" method="post">
 Class-Name: <input type="text" name="className"/><br><br>
 Class-Capacity: <input type="text" name="classCapacity"/><br><br>
 Class-Accessibility: <input type="text" name="classAccessibility"/><br><br>
 Class-Size:  <input type="text" name="classSize"/><br><br>
 Floor-Level: <input type="text" name="floorLevel"/><br><br>
 <tr>
   <td>
        <input type="submit" value="Create-List">
   </td>
 </tr>
 </form>
</body>
</html>
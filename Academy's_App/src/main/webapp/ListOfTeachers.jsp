<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List-Of-Teachers</title>
</head>
<body>
<h1 align="center">Welcome to Teachers List Setup Page</h1>
 <h3>You can setup the list of teachers by entering the relevant information below</h3>
 <form action="<%= request.getContextPath()%>/teachers" method="post">
 First-Name: <input type="text" name="firstName"/><br><br>
 Last-Name: <input type="text" name="lastName"/><br><br>
 Qualification: <input type="text" name="qualification"/><br><br>
 Age:  <input type="text" name="age"/><br><br>
 Gender: <input type="text" name="gender"/><br><br>
 <tr>
   <td>
        <input type="submit" value="Create-List">
   </td>
 </tr>
 </form>
</body>
</html>
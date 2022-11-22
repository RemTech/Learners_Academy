<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List-Of-Subjects</title>
</head>
<body>
<h1 align="center">Welcome to Subjects Setup Page</h1>
 <h3>You can setup the list of subjects by entering the relevant information below</h3>
 <form action="<%= request.getContextPath() %>/SubjectList" method="post">
 Subject-Name: <input type="text" name="subjectName"/><br><br>
 Subject-Code: <input type="text" name="subjectCode"/><br><br>
 <tr>
   <td>
        <input type="submit" value="Create-List">
   </td>
 </tr>
 </form>
</body>
</html>
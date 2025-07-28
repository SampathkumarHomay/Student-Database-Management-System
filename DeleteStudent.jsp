<%--<%@page import="java.sql.ResultSet"%>--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>




<%--  <%
	ResultSet rs = (ResultSet) request.getAttribute("resultSet");
     rs.next();
	%>
	--%>

<h1>Enter the Student Id to Delete</h1>

<form action="delete-student" method="post">
<input type="number" placeholder="Enter StudentId" name="studentId"><br>

<input type="submit" value="DELETE">

</form>

</body>
</html>



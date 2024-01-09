<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>

	<%
	session.invalidate();
	%>

	<br>
	<br>
	<br>
	<center>
		<h3>!!! Thank You !!!</h3>
		<br> <br> <br> <a href="index.jsp">Sign In Again</a>

	</center>
</body>
</html>
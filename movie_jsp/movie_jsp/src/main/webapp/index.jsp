<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body style="background-color: grey">
<div align="center"   style=" background-color: white ;width: 500px;height: 500px; margin-top: 100px;margin-left: 550px ;border: 2px solid black;" class="container">
<br><br><br><br><br>
<h2 align="center">Log In</h2>
<form method="Post" action="login.jsp" >
Email :<input type="text" name="email"/><br><br>
Password :<input type="password" name="password"/><br><br>
<button class="btn btn-primary" onclick="login.jsp">Log In</button>
<a href="register.jsp" >Sign Up</a>
</div>
</form>
</body>
</html>
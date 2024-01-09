<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body style="background-color: grey">
	<div align="center"
		style="background-color: white; width: 500px; height: 500px; margin-top: 100px; margin-left: 550px; border: 2px solid black;"
		class="container">
		<form action="registerAuth.jsp" method="post">
			<br>
			<br>
			<h1 align="center" style="color: red">Register</h1>
			First Name :<input type="text" name="first_name"><br>
			<br> Last Name:<input type="text" name="last_name"> <br>
			<br> Email :<input type="text" name="email"><br>
			<br> Password :<input type="password" name="password"><br>
			<br> Phone No :<input type="number" name="phone_no"><br>
			<br> Birth Date:<input type="date" name="birth_date" ><br>
			<br> <input type="submit" value="Submit"> 
            

		</form>

	</div>

</body>
</html>
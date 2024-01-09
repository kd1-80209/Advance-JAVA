<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean"
		scope="session"></jsp:useBean>
	<jsp:setProperty name="lb" property="*" />

	${lb.fetchUser()}

	<c:choose>
		<c:when test="${empty lb.user}">
			Invalid Email or Password...
			Please Try Again... 
			<br>
			<br>
			<a href="index.jsp">Sign In Again</a>
		</c:when>

		<c:when test="${lb.user.role =='admin'}">
			<c:redirect url="result.jsp"></c:redirect>
		</c:when>

		<c:when test="${lb.user.role == 'voter' }">
			<c:redirect url="candlist.jsp"></c:redirect>
		</c:when>

		<c:otherwise>
			<c:redirect url="index.jsp"></c:redirect>
		</c:otherwise>
	</c:choose>

</body>
</html>
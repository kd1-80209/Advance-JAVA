<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voting Done</title>
</head>
<body>

	<h2>Hello, ${lb.user.firstName} ${lb.user.lastName}</h2>
	<hr>

	<jsp:useBean id="vd" class="com.sunbeam.beans.VotingDoneBean"></jsp:useBean>
	<jsp:setProperty property="candId" name="vd" param="candidate" />
	<jsp:setProperty property="userId" name="vd" value="${lb.user.id }" />
	${vd.doneVoting() }

	<br>
	<br>
	<br>
	<center>
		<h3>${vd.message}</h3>
		<br> <br> <br> 
		<a href="logout.jsp">Logout</a>

	</center>
</body>
</html>
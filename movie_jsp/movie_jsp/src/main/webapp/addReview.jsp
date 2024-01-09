<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: grey">

	<div align="center"
		style="background-color: white; width: 500px; height: 500px; margin-top: 100px; margin-left: 550px; border: 2px solid black;"
		class="container">
		<jsp:useBean id="find" class="com.sunbeam.beans.GetAllMovie" />
		${find.allMovies() }
		<form action="revievAdded.jsp" method="post">
			<br> <br>
			<h1 align="center" style="color: red">Give Review</h1>
			<input type="hidden" value="${lc.user.id}" name="uid">
			<h3>Select Movie :</h3>
			<select name="mid">
				<c:forEach var="m" items="${find.mlist}">
					<option value="${m.id}">${m.title}</option>
				</c:forEach>
			</select><br> <br> Rating:<input type="text" name="rating">
			<br> <br> Review:<input type="text" name="review"><br>
			<br> <input type="submit" value="Submit">


		</form>

	</div>

</body>
</html>
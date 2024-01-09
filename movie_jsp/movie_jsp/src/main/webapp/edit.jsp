<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Review</title>
</head>
<body   style="background-color: grey">

	<jsp:useBean id="find" class="com.sunbeam.beans.GetAllMovie" />
	${ find.allMovies()}
	<div align="center"
		style="background-color: white; width: 500px; height: 500px; margin-top: 100px; margin-left: 550px; border: 2px solid black;"
		class="container">
		<jsp:useBean id="review" class="com.sunbeam.beans.GetReviewById"></jsp:useBean>
		<jsp:setProperty property="id" name="review" param="id" />
		${review.findById()  }
		<form action="editedReview.jsp" method="post">
			<br> <br>
			<h1 align="center" style="color: red">Edit Review</h1>

			<c:forEach var="m" items="${find.mlist}">
				<c:if test="${review.review. movie_id ==m.id}">
					<input title="Not To Edit" value="${m.id}" name="mid" readonly="readonly" >${m.title}</input>

				</c:if>
			</c:forEach>
			<br> <input title=" Edit review" type="hidden" value="${review.review.id}" name="rid">
			<br> Rating:<input title=" Edit rating" type="text" name="rating"
				value="${review.review.rating}"> <br> <br> Review:<input title=" Edit review"
				type="text" name="review" value="${review.review.review}""><br>
			<br> <input type="submit" value="Submit">


		</form>

	</div>
</body>
</html>
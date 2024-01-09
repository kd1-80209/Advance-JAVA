<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Review List</title>
</head>
<body style="background-color: grey">
	<div align="center"
		style="background-color: white; width: 500px; height: 550px; margin-top: 100px; margin-left: 550px; border: 2px solid black;"
		class="container">
		<h1>Movie Review Application</h1>
		<hr>
		Hello ,${lc.user.first_name } ${lc.user.last_name } <br>
		<hr>
			
		<jsp:useBean id="rl" class="com.sunbeam.beans.ReviewListBeans" />
		<jsp:useBean id="movie" class="com.sunbeam.beans.GetAllMovie"></jsp:useBean>
		${movie.allMovies()}
		<jsp:setProperty property="type" name="rl" param="type" />
		<jsp:setProperty property="uid" name="rl" value="${lc.user.id}" />

		${rl.reviewList()} <a href="reviewList.jsp?type=All">All Review</a>| <a
			href="reviewList.jsp?type=My">My Review</a>| <a
			href="reviewList.jsp?type=Shared">Shared Review</a>| <a
			href="addReview.jsp">Add Review</a>
		<hr>

		<table style="text-align: center;" border="2">
			<thead style="background-color: aqua">
				<tr>
					<th>Review Id</th>
					<th>Movie Name</th>
					<th>Rating</th>
					<th>Review</th>
					<th>Delete</th>
					<th>Edit</th>
					<th>Share</th>



				</tr>
			</thead>
			<tbody>
				<c:forEach var="r" items="${rl.reList }">
					<tr>
						<td>${r.id }</td>
						<c:forEach var="m" items="${movie.mlist }">
							<c:if test="${r.movie_id==m.id }">
								<td>${m.title }</td>

							</c:if>
						</c:forEach>

						<td>${r.rating }</td>
						<td>${r.review }</td>
						<c:if test="${lc.user.id==r.user_id}">
							<td><a href="delete.jsp?id=${r.id}"><img alt="delete"
									src="delete.jpg" style="height: 24px; width: 24px"
									title="Delete Review" /> </a></td>
							<td><a href="edit.jsp?id=${r.id}"><img alt="edit"
									src="edit.jpg" style="height: 24px; width: 24px"
									title="Edit Review" /> </a></td>

							<td><a href="share.jsp?id=${r.id}"><img alt="share"
									src="share.jpg" style="height: 24px; width: 24px"
									title="Share Review" /> </a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr>
		<a href="signOut.jsp">Sign Out</a>
		<hr>
	</div>
</body>
</html>

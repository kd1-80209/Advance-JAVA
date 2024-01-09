<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="addRev" class="com.sunbeam.beans.AddReview"></jsp:useBean>

	<jsp:setProperty property="uid" name="addRev" param="uid" />
		<jsp:setProperty property="mid" name="addRev" param="mid"/>
		<jsp:setProperty property="rating" name="addRev" param="rating"/>
		<jsp:setProperty property="review" name="addRev" param="review" />
	
	${addRev.addReview()}
	<c:if test="${addRev.getStatus()}">
		<c:redirect url="reviewList.jsp"></c:redirect>
	</c:if>
</body>
</html>
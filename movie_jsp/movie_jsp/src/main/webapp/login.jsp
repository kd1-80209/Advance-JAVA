<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="lc" class="com.sunbeam.beans.LoginBeans"
		scope="session" />
	<jsp:setProperty name="lc" property="email" param="email" />
	<jsp:setProperty property="password" name="lc" param="password" />
	${lc.authentication() }
	<c:choose>
		<c:when test="${empty lc.user}">
		
              Invalid UserId Or Password..............!!!!!!<br>
			<br>
			<a href="index.jsp">Login Again</a>
		</c:when>
		<c:otherwise>
			<c:redirect url="reviewList.jsp"></c:redirect>
		</c:otherwise>

	</c:choose>
</body>
</html>
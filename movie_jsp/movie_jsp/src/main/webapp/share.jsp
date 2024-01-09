<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        	<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body  style="background-color: grey">

<div align="center"
		style="background-color: white; width: 500px; height: 500px; margin-top: 100px; margin-left: 550px; border: 2px solid black;"
		class="container">
		<jsp:useBean id="find" class="com.sunbeam.beans.GetAllMovie"/>
		<jsp:useBean id="share" class="com.sunbeam.beans.ShareBean"></jsp:useBean>
		<jsp:setProperty property="rid" name="share" param="rid"/>
		
		${find.allUser()}
		<form action="shareReview.jsp" method="post">
			<br>
			<br>
			<h1 align="center" style="color: red">Share Review</h1>
			<h3>Share With :</h3>
			<select name="uid">
			<c:forEach var="u" items="${find.ulist}" >
			 <option value="${u.id}">${u.first_name}</option>
			</c:forEach>
			</select><br>
			
			<br> <input type="submit" value="Submit"> 
            

		</form>

	</div>


</body>
</html>
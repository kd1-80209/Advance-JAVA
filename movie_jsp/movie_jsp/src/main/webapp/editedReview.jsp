<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edited Review</title>

<jsp:useBean id="edrevi" class="com.sunbeam.beans.EditReview"></jsp:useBean>
<jsp:setProperty property="mid" name="edrevi" param="mid" />
<jsp:setProperty property="rid" name="edrevi" param="rid" />
<jsp:setProperty property="rating" name="edrevi" param="rating" />
<jsp:setProperty property="review" name="edrevi" param="review" />
<jsp:setProperty property="uid" name="edrevi"  value="${lc.user.id}"/>
  ${edrevi.editReview()}
<c:if test="${edrevi.getStatus()}">
	<c:redirect url="reviewList.jsp?type=My"></c:redirect>
</c:if>
</head>
<body>

</body>
</html>
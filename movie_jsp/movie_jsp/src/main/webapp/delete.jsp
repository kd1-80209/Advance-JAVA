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
<jsp:useBean id="delrev" class="com.sunbeam.beans.DeleteReview"></jsp:useBean>
<jsp:setProperty property="id" name="delrev" param="id"/>
${delrev.delete()}
<c:if test="${delrev.status}">
  <c:redirect url="reviewList.jsp?type=My"></c:redirect>
</c:if>

</body>
</html>
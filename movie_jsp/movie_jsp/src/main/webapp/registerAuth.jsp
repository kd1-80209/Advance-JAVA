<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<jsp:useBean id="re" class="com.sunbeam.beans.RegisterAuth"></jsp:useBean>
<jsp:setProperty property="*" name="re"/>
${re.register()}
 
 <c:if test="${re.getStatus()}">
 
 <c:redirect url="registerSuccess.jsp">
 </c:redirect>
 
 </c:if>

 <br><br>
 <a href="login.jsp">Log In</a>  
</body>
</html>
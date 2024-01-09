<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="share" class="com.sunbeam.beans.ShareBean"></jsp:useBean>
<jsp:setProperty property="uid" name="share" param="uid"/>
<jsp:setProperty property="rid" name="share" param="rid"/>
${share.share()}




</body>
</html>
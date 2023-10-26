<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4 align="center">Love calculator</h4>
	<div style="float: right">
		<a href="#">logout</a>
	</div>
	<p>Hi ${user.username} </p>
	<p>Email successfully send to ${emailDto.userEmail}</p>
	<div>
		<a href="#">try with somebody else</a>
	</div>
</body>
</html>
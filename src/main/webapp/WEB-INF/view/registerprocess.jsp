<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<form>
	<div><a href="home" style="float: right;">Sign In</a></div>
	<div align="center">
		<h4>Registeration Successful</h4>
		<p>Name: ${data.name}</p>
		<p>UserName: ${data.username}</p>
		<p>Password: ${data.password}</p>
		<p>Country: ${data.country}</p>
		<p>Hobby: 
		<c:forEach var="temp" items="${data.hobby}">
		${temp}
		</c:forEach>
		</p> 
		<p>Gender: ${data.gender}</p>
		<p>Email: ${data.communicationDTO.email}</p> <!-- we use this when it is nested object -->
	    <p>Phone: ${data.communicationDTO.phone}</p>
	</div>
	</form>
</body>
</html>
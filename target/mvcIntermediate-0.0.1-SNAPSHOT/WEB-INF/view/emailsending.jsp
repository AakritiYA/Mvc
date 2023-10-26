<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<form:form action="mailsuccess" method="get" modelAttribute="emailDto,user1" >
		<h4 align="center">Love calculator</h4>
		<div style="float: right">
			<a href="#">logout</a>
		</div>
		<p>Hi ${user.username}</p>
		<div>
			<p>

				<label for="el"> Your Email id: </label> <input type="email" id="el"
					name="userEmail" /> <input type="submit" value="send" />
			</p>

		</div>
		<div>
			<a href="#">try with somebody else</a>
		</div>
	</form:form>
</body>
</html>
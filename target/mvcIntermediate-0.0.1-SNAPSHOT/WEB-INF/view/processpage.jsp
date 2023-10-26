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
	<div>
		<a href="" style="float: right">logout</a>
	</div>
	<p>${user.username} and ${user.lovername}</p>
	<!-- model name ke aage "." lga kr o form input name dena hai ju chaiye humme dusre view page se...  -->
	<div style = "float: left">
		<a href="emailpage">send result to email</a>
	</div>
</body>
</html>
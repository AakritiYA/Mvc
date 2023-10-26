<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
.error{
color: red;
position: fixed;
margin-left: 30px;
}
</style>

<meta charset="UTF-8">
<title>Home page</title>
<script type="text/javascript">
function check(){
	var temp = document.getElementById('yn').value;
	if(temp.length < 1){
		alert("Your Name can not be empty");
		return false
	}
}
</script>
</head>
<body>
	<form:form action="processhomepage" method="get" modelAttribute="user" >
		<div>
			<a href="register" style="float: right">Register</a>
		</div>
		<div align="center">
			<h1>Love Calculator</h1>
			<p>
				<label for="yn">Your Name: </label> <input type="text" id="yn"
					name="username" /> <form:errors path="username" cssClass="error" />
			</p>
			<p>
				<label for="ln"> Lover Name: </label> <input type="text" id="ln"
					name="lovername" />
			</p>
			<p>
			<input type="checkbox" id="check" name="termandcondition">
			<label for="check"> I am agreeing that this is for fun</label> <form:errors path="termandcondition" cssClass="error"></form:errors> 
			</p>
			<input type="submit" value="Calculate" />
		</div>
	</form:form>
</body>
</html>
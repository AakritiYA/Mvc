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
<title>Insert title here</title>
</head>
<body>
	<form:form action="rprocess" method="get" modelAttribute="data">
		<h5 align="center">Love Calculator</h5>
		<div><a href="home" style="float: right;">Sign In</a></div>
		<div align="center">
			<p>
				<label for="ne">Name: </label> <input type="text" id="ne"
					name="name" /><form:errors path="name" cssClass="error"></form:errors>
			</p>
			<p>
				<label for="ue">User Name: </label> <input type="text" id="ue"
					name="username" />
			</p>
			<p>
				<label for="pd">Password: </label> <input type="password" id="pd"
					name="password" />
			</p>
			<p>
				<label for="ct">Country: </label> <input type="text" id="ct"
					name="country" />
			</p>
			<p>
				<label for="hy">Hobby: </label> <input type="checkbox" id="hy"
					name="hobby" value="Reading"/> Reading <input type="checkbox" id="hy"
					name="hobby" value="Traveling"/>Traveling <input type="checkbox" id="hy"
					name="hobby" value="Programming"/>Programming
			</p>
			<p>
				<label for="gn">Gender: <input type="radio" id="gn"
					name="gender" value="male"/>Male
				  <input type="radio" id="gn" name="gender" value="female" />Female </label>
					
			</p>
			<p>
				<label for="el">Email: </label> <input type="email" id="el"
					name="communicationDTO.email" /> <!-- we use nested object so we write like this... -->
					
			</p>
			<p>
				<label for="pe">Phone: </label> <input type="text" id="pe"
					name="communicationDTO.phone" /> <!--we use nested object so we write like this...  -->
					<form:errors path="communicationDTO.phone" cssClass="error"></form:errors>
					
			</p>
			<p>
				<input type="submit" value="Register"/>
			</p>

		</div>
	</form:form>
</body>
</html>
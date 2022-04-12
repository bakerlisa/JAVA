<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Practicing</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/script.js"></script>
</head>
<body>
<div>
	<h1>Practicing</h1>
	<form action="/formSubmit" method="post">
		<div>
			<label for="name">Name</label>
			<input type="text" name="name" value='<c:out value="${name }"/>' />
			<p><c:out value="${nameError } "/></p>
		</div>
		<div>
			<label for="email">Email</label>
			<input type="text" name="email" value='<c:out value="${email }"/>'/>
			<p><c:out value="${emailError }"/></p>
		</div>
		<div>
			<label for="password">Password</label>
			<input type="text" name="password" />
			<p><c:out value="${passwordError }"/></p>
		</div>
		<div>
			<label for="confirm">Confirm Password</label>
			<input type="text" name="confirm" />
			<p><c:out value="${confirmError }"/></p>
		</div>
		<input type="submit" value="submit" />
	</form>
<a href="dashboard">Dashboard</a> | <a href="logout">Logout</a> | <a href="formTwo">Form</a>
</div>


</body>
</html>
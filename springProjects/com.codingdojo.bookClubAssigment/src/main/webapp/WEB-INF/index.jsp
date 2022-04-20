<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Product / Category </title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="container">
		<h1 style="padding-bottom:0;">Welcome Welcome Welcome!</h1>
		<h3 style="padding:0;">Here you will find mystery magic and mayhem! </h3>
		<div class="flex">
			<div class="col-2">
				<h2>Register</h2>
				<form:form method="post" action="/api/register" modelAttribute="newUser">
					<div>
						<span>
							<form:label path="firstName">First Name:</form:label>
							<form:errors path="firstName" class="error"/>
						</span>
						<form:input path="firstName" type="text"/>
					</div>
					
					<div>
						<span>
							<form:label path="lastName">Last Name:</form:label>
							<form:errors path="lastName" class="error"/>
						</span>
						<form:input path="lastName" type="text"/>
					</div>
					
					<div>
						<span>
							<form:label path="email">Email:</form:label>
							<form:errors path="email" class="error"/>
						</span>
						<form:input path="email" type="email"/>
					</div>
					
					<div>
						<span>
							<form:label path="password">Password:</form:label>
							<form:errors path="password" class="error"/>
						</span>
						<form:input path="password" type="password"/>
					</div>
					
					<div>
						<span>
							<form:label path="confirm">Confirm Password:</form:label>
							<form:errors path="confirm" class="error"/>
						</span>
						<form:input path="confirm" type="password"/>
					</div>
					
					<input type="submit" value="Register" class="submit" />
				</form:form>
			</div>
			<div class="col-2" >
				<h2>Login</h2>
				
				<form:form method="post" action="/api/login" modelAttribute="newLogin">
					<div>
						<span>
							<form:label path="email">Email:</form:label>
							<form:errors path="email" class="error"/>
						</span>
						<form:input path="email" type="email"/>
					</div>
					<div>
						<span>
							<form:label path="password">Password:</form:label>
							<form:errors path="password" class="error"/>
						</span>
						<form:input path="password" type="password"/>
					</div>
					
					<input type="submit" value="Login" class="submit" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
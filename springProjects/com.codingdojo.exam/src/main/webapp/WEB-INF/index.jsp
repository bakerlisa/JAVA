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
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
<div class="container">
	<h1>Joy Bundler</h1>
	<p class="subtitle">Where names take on names, will your win?</p>
	<div class="flex">
			<div class="col-2">
				<h2>Register</h2>
				<form:form method="post" action="/api/register" modelAttribute="newUser">
					<div>
						<span>
							<form:label path="fullName">Full Name:</form:label>
						</span>
						<form:input path="fullName" type="text"/>
						<form:errors path="fullName" class="error"/>
					</div>
					
					<div>
						<span>
							<form:label path="email">Email:</form:label>
						</span>
						<form:input path="email" type="email"/>
						<form:errors path="email" class="error"/>
					</div>
					
					<div>
						<span>
							<form:label path="password">Password:</form:label>
						</span>
						<form:input path="password" type="password"/>
						<form:errors path="password" class="error"/>
					</div>
					
					<div>
						<span>
							<form:label path="confirm">Confirm Password:</form:label>
						</span>
						<form:input path="confirm" type="password"/>
						<form:errors path="confirm" class="error"/>
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
						</span>
						<form:input path="email" type="email"/>
						<form:errors path="email" class="error"/>
					</div>
					<div>
						<span>
							<form:label path="password">Password:</form:label>
						</span>
						<form:input path="password" type="password"/>
						<form:errors path="password" class="error"/>
					</div>
					
					<input type="submit" value="Login" class="submit" />
				</form:form>
			</div>
		</div>
</div>

</body>
</html>
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
<title>Smugator</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body class="home">
    <div class="container"> <!-- Beginning of Container -->
        <h1>Smugator</h1>
        <p>[ smug - a - tor] Definition: an app to track your expenses, in order for you to have more money to spend on more stuff</p>
        
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
    </div> <!-- End of Container -->
</body>
</html>
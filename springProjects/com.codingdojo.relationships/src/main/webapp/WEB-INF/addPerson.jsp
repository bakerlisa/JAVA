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
<nav>
	<a href="/">Dash</a> |
	<a href="/add/person">Add Person</a> |
	<a href="/add/license">Add License</a> 
</nav>
	<h1>Add Person</h1>
	
</div>
	<div class="container">
		<form:form action="/api/add/person" method="post" modelAttribute="person">
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
			<input type="submit" value="Add Person" class="submit" />
		</form:form>
		
	</div>

</body>
</html>
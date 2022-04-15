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
<title>Edit</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="backgrd"></div>
	
	<div class="container">
		<h1>Edit Language</h1>
		<a href="/languages">Dashboard</a>
		<form:form action="/api/update" method="post" modelAttribute="language">
	<div>
		<span>
		<form:label path="name">Name:</form:label>
		<form:errors path="name" class="error" />
		</span>
			<form:input type="text" path="name"/>
	</div>
	
	<div>
		<span>
		<form:label path="creator">Creator:</form:label>
		<form:errors path="creator" class="error"/>
		</span>
			<form:input type="text" path="creator"/>
	</div>
	
	<div>
		<span>
		<form:label path="version">version:</form:label>
		<form:errors path="version" class="error"/>
		</span>
			<form:input type="number" path="version" step=".01"/>
	</div>
	
	<form:input type="hidden" path="id" />
	<input type="submit" value="submit" class="submit"/>
	</form:form>
	</div>
</body>
</html>
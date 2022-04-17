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
	<title>Student Roster</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
<div class="container">
	<nav>
		<a href="/dashboard">Dash</a> | 
		<a href="/add/student">Add Student</a> |
		<a href="/students">All Students</a>|
		<a href="/add/dorm">Add Dorm</a>|
		<a href="/dorms">All Dorms</a>
	</nav>
	<h1>Add Dorm</h1>
	
	<form:form method="post" action="/api/add/dorm" modelAttribute="dorm">
	<div>
		<span>
			<form:label path="name">Dorm Name</form:label>
			<form:errors path="name" class="error"/>
		</span>
		<form:input path="name" type="text"/>
	</div>
	
	<input type="submit" value="Add Dorm" class="submit"/>
	</form:form>
	
</div>
</body>
</html>
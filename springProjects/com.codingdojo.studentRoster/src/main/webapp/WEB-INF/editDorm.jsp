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
	<h1> Edit Dorm - ${editDorm.name}</h1>
	
	<div>
		<form action='/delete/dorm/<c:out value="${editDorm.id}"/>' method="post" class="delete"><input type="hidden" name="_method" value="delete"><input type="submit" value="Delete"></form>
		
		<form:form method="post" action="/api/dorm/${editDorm.id}" modelAttribute="dorm">
			<div>
				<span>
					<form:label path="name">Dorm Name</form:label>
					<form:errors path="name" class="error"/>
				</span>
				<form:input path="name" type="text" value="${editDorm.name }"/>
			</div>
			<input type="submit" value="Update Dorm" class="submit"/>
		</form:form>
	</div>

	

	
</div>
</body>
</html>
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
	<h1>All Students</h1>
	<div class="elm">
		<c:forEach var="student" items="${students }">
			<div><a href="/student/<c:out value='${student.id }'/>"> ${student.name } </a> <form action='/delete/student/<c:out value="${student.id}"/>' method="post" class="delete"><input type="hidden" name="_method" value="delete"><input type="submit" value="Delete"></form></div>
		</c:forEach>
	</div>
	

	
</div>
</body>
</html>
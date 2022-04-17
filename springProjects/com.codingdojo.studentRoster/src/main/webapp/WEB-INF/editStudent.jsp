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
	<h1>Edit Student : ${student.firstName} ${student.lastName}</h1>
<form action='/delete/student/<c:out value="${student.id}"/>' method="post" class="delete"><input type="hidden" name="_method" value="delete"><input type="submit" value="Delete"></form>
	
	<form:form megthod="post" action="/api/edit/student" modelAttribute="student">
		<div>
			<span>
				<form:label path="firstName">First Name:</form:label>
				<form:errors path="firstName" class="error"/>
			</span>
			<form:input type="text" path="firstName"/>
		</div>
		<div>
			<span>
				<form:label path="lastName">Last Name:</form:label>
				<form:errors path="lastName" class="error"/>
			</span>
			<form:input type="text" path="lastName"/>
		</div>
		<div>
			<span>
				<form:label path="dorm">Dorm:</form:label>
				<form:errors path="dorm" class="error"/>
			</span>
			
			<form:select path="dorm" >
				<c:forEach var="dorm" items="${dorms }">
					<form:option value="${dorm.id }">${dorm.name}</form:option>
				</c:forEach>	
			</form:select>
		</div>
		
		<input type="hidden" name="id" value="${student.id}"/>
		<input type="submit" value="Add Student" class="submit"/>
	</form:form>
	
</div>
</body>
</html>
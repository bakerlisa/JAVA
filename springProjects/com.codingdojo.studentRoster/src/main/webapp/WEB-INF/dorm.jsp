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
	<h1> Dorm - ${dorm.name}</h1>
	<p>${message }</p>
	
	<form:form action="/api/edit/dorm/student" method="post" modelAttribute="student">
		 <div>
			<span>
				<form:label path="">Student</form:label>
				<form:errors path="id" class="error"/>
			</span>
			<form:select path="id">
				<c:forEach var="stu" items="${students }">
					<option value="${stu.id} ">${ stu.firstName} ${stu.lastName }</option> 
				</c:forEach>
			</form:select> 
		</div>
		
		<input type="hidden" name="dorm" value="${dorm.id}" />
		<input type="submit" value="Add Student" class="submit"/>
	</form:form>
	
	<div class="controllers">
		<form action='/delete/dorm/<c:out value="${dorm.id}"/>' method="post" class="delete"><input type="hidden" name="_method" value="delete"><input type="submit" value="Delete"></form>
		<a href="/edit/dorm/<c:out value="${dorm.id}"/>">Edit</a>
	</div>
	<div class="elm studentsWrp">
		<c:forEach var="student" items="${dorm.students}">
			<div>${ student.firstName} ${ student.lastName}</div>
		</c:forEach>
	</div>

	
</div>
</body>
</html>
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
<html>
<head>
<meta charset="UTF-8">
<title>Dash</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>

	<div class="container">
		<nav>
			<a href="/dashboard">Dashboard</a> |
			<a href="/students">Students</a> |
			<a href="/classes">Classes</a> |
			<a href="/add/student">Add Student</a> |
			<a href="/add/class">Add Class</a> |
			<a href="/logout">Logout</a>
		</nav>
		
		<h1 style="padding-bottom:0;">${course.subject } -  ${course.id } </h1>
		<div class="flex">
			<h2>Student Roster</h2>
			<ol class="classMemebers">
				<c:forEach var="current" items="${currentMembers }">
					<li>${current.name }</li>
				</c:forEach>
			</ol>
		
		<form:form method="post" action="/api/add/studentcourse" modelAttribute="studentcourse">
			<div>
				<span>
					<form:label path="student">Student</form:label>
					<form:errors path="student" class="error"/>
				</span>
				<form:select path="student">
					<c:forEach var="mate" items="${members }">
						<form:option value="${mate.id }">${mate.name }</form:option>
					</c:forEach>
				</form:select>
			</div>
				<input type="hidden" name="course" value="${course.id} " />
			<input type="submit" value="Add Student" class="submit"/>
		</form:form>
			
			
		</div>
	</div>

</body>
</html>
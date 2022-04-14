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
		<h1>New Candy for the party!</h1>
		<br/>
		<a href="/dashboard">Home</a>
		<a href="/newCandy">NewCandy</a>
		<a href="/oneCandy">OneCandy</a>
		<a href="/updateCandy">UpdateCandy</a>
	</div>
	
	<form:form action="/api/create/candy" method="post" modelAttribute="candy">
		<div>
			<span>		
				<form:label path="name">Name</form:label>
				<form:errors path="name" class="error"/>
			</span>
			<form:input type="text" path="name"/> 
		</div>
	</form:form>
</body>
</html>
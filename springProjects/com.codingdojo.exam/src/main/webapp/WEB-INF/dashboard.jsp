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
			<a href="/dashboard">Dashboard</a> |
			<a href="/add/item">Add Item</a> |
			<a href="/item">Item</a> |
			<a href="/logout">Logout</a>
		</nav>
	<h1>Welcome Welcome Welcome!</h1>
	<h3><u>Main Event</u>: ${logged.firstName } ${logged.lastName } @ 7pm MST</h3>
	<div class="flex">
	</div>
</div>
</body>
</html>
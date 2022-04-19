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
		<a href="/">Index</a> | 
		<a href="/dashboard">Dash</a> | 
		<a href="/new/plant">New Plant</a> | 
		<a href="/edit/plant">Edit Plant</a> |
		<a href="/plant">One Plant</a> 
	</nav>
	
		<h1>Dashboard</h1>
		<h3>Join our growing community</h3>
		
		
	</div>
</body>
</html>
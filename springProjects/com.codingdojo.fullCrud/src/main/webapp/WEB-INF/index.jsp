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
		<h1>What candy will you bring to the party!?</h1>
		<br/>
		<a href="/dashboard">Home</a>
		<a href="/newCandy">NewCandy</a>
		<a href="/oneCandy">OneCandy</a>
		<a href="/updateCandy">UpdateCandy</a>
		
		<div class="ele titles">
			<p class="name">Name</p>
			<p class="brand">Brand</p>
			<p class="price">Price</p>
			<p class="rating">Rating</p>
			<p class="actions">Actions</p>
		</div>
	
		<c:forEach var="candy" items="${candies}">
			<div class="ele">
    			<p class="name"><a href="oneCandy/<c:out value="${candy.id}"/>"><c:out value=" ${candy.name}"/></a></p>
    			<p class="brand"><c:out value="${candy.brand}"/></p>
   				<p class="price">$<c:out value="${candy.price}"/></p>
   				<p class="rating"><c:out value="${candy.rating}"/></p>
   				<p class="actins"></p>
   			</div>
		</c:forEach>

	</div>
</body>
</html>
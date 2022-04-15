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
	
	
	<form:form action="/api/create/candy" method="post" modelAttribute="candy">
		<div>
			<span>		
				<form:label path="name">Name</form:label>
				<form:errors path="name" class="error"/>
			</span>
			<form:input type="text" path="name"/> 
		</div>
		
		<div>
			<span>
				<form:label path="brand">Brand</form:label>
				<form:errors path="brand" class="error"/> 
			</span>
				<form:input path="brand" type="text" class=""/>
		</div>
		
		<div>
			<span>
				<form:label path="rating">Rating</form:label>
				<form:errors path="rating" class="error"/>
			</span>
			<form:input path="rating" type="number" />
		</div>
		
		<div>
			<span>
				<form:label path="price">Price</form:label>
				<form:errors path="price" class="error"/>
			</span>
			<form:input type="number" path="price"/>
		</div>
		<input type="submit" value="submit" />
	</form:form>
	</div>
</body>
</html>
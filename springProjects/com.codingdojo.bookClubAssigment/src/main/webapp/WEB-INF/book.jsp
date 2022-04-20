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
<title> Product / Category </title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="container">
		<nav>
			<a href="/dashboard">Dashboard</a> |
			<a href="/add/book">Add Book</a> |
			<a href="/logout">Logout</a>
		</nav>
		<h1 style="padding-bottom:0;">${book.title }</h1>
		<h3 style="padding:0;">For every book you read you live another life in another world</h3>
		<div class="button-wrp">
			<a href="/add/book" class="button">Add Book</a>
		</div>
		
		 <c:choose>
			<c:when test="${logged  == book.user.id}" >
				<h4>You've read ${book.title } by ${book.author }</h4>
				<p class="thoughts">Here are your Thoughts:</p>
			</c:when>
			
			<c:otherwise>
				<h4>${book.user.firstName  } read ${book.title } by ${book.author }</h4>
				<p class="thoughts">Here are <span>${book.user.firstName  } ${book.user.lastName  }</span> Thoughts:</p>
  			</c:otherwise> 
		</c:choose> 
		
		<p class="description">${book.thoughts }</p>
		 <c:choose>
			<c:when test="${logged  == book.user.id}" >
				<a href="/edit/book/${ book.id}" class="button">Edit book</a>
			</c:when>
		</c:choose>
	</div>
</body>
</html>
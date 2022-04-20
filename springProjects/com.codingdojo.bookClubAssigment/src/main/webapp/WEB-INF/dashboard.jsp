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
		<h1 style="padding-bottom:0;">Welcome Welcome Welcome ${logged.firstName }!</h1>
		<h3 style="padding:0;">Here you will find mystery magic and mayhem! </h3>
		
		<c:choose>
  			<c:when test="${allBooks.size() == 0}">
				<h3 class="gold">No books at this time</h3>
  			</c:when>

  			<c:otherwise>
  				<div class="elm title">
					<p>Title</p>
					<p>Author</p>
					<p>Owner</p>
				</div>
				<c:forEach var="book" items="${allBooks }">
					<div class="elm ">
						<p><a href="/book/${book.id}">${book.title }</a></p>
						<p>${book.author }</p>
						<p>${book.user.firstName } ${book.user.lastName }</p>
					</div>
				</c:forEach>	
  			</c:otherwise>
		</c:choose>
			
		<div class="button-wrp">
			<a href="/add/book" class="button">Add Book</a>
		</div>
	</div>
</body>
</html>
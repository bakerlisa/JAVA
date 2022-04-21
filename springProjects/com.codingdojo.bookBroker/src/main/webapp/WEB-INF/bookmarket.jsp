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
<title>Book Broker</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="container">
		<nav>
			<a href="/dashboard">Dashboard</a> |
			<a href="/add/book">Add Book</a> |
			<a href="/update/book">Update Book</a> |
			<a href="/book">Book</a> |
			<a href="/logout">Logout</a>
		</nav>
		
		<h1>Book Broker </h1>
		
		<div class="booksTable">
		<c:choose>
  			<c:when test="${books.size() == 0}">
				<h4 class="center">All the best books are gone, come back later</h4>
  			</c:when>
  			<c:otherwise>
  				<div class="elm titles">
  					<p class="title">Title</p>
  					<p class="author">Author</p>
  					<p class="owner">Owner</p>
  					<p class="tg">Action</p>
  				</div>
				<c:forEach var="bk" items="${books }">
					<div class="author">${bk.title }</div>
					<div class="title">${bk.author }</div>
					<div class="owner">${bk.user.firstName }</div>
					
					<c:choose>
						<c:when test="${bk.user.id == logged.id }">
								<div class="actions"> Edit | Delete</div>
						</c:when>
						<c:otherwise>
							<div class="actions">Borrow</div>
						</c:otherwise>
					</c:choose>
						
				</c:forEach>
			</c:otherwise>
		</c:choose>
		</div>
		
	</div>
</body>
</html>
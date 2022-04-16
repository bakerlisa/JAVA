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
			<a href="/songs/add">Add New</a>
			<a href="top">Top Songs</a>
		</nav>
		
		<h1>Looky Looky you have Music-key</h1>
		<div class="dash">
			 <c:choose>
			 
			 	 <c:when test="${lookify.size() < 1}">
			 	 <h3>No Music! Add a Song!</h3>
			 	 </c:when>    
    			
    			<c:otherwise>
    				<div class="elm titles">
			 			<p class="name">Name</p>
			 			<p class="rating">Rating</p>
			 			<p class="actions">Actions</p>
					 </div>
					 <c:forEach var="song" items="${lookify }">
					 	<div class="elm">
					 		<p class="title"><c:out value="${song.title }"/></p>
			 				<p class="rating"><c:out value="${song.rating }"/></p>
			 				<form action='/delete/<c:out value="${song.id}"/>' method="post" class="delete">
    							<input type="hidden" name="_method" value="delete">
    							<input type="submit" value="Delete">
							</form>  
			 			</div>	
					 </c:forEach>
    			</c:otherwise>
			 </c:choose>
			

			 
			 
			 
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
<title>All Books</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>

<div class="container">
	<h1>All Deee Books!</h1>

		<div class="bookTitles">
		<p class="id">ID:</p>
		<p class="title">Title:</p>
		<p class="language">Language:</p>
		<p class="numberOfPages">Number of Pages:</p>
		</div>
		<c:forEach var="book" items="${books}">
			<div class="bookWrp">
				<p class="id"><c:out value = "${book.id}"/></p>
         		<p class="title"><a href="/book/<c:out value = "${book.id}"/>"><c:out value = "${book.title}"/></a><p>
         		<p class="language"><c:out value = "${book.language}"/><p>
         		<p class="numberOfPages"><c:out value = "${book.numberOfPages}"/><p>
         	</div>
   		</c:forEach>
   	</div>
</body>
</html>
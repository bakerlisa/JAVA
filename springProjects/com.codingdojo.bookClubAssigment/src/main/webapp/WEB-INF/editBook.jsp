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
		<h1 style="padding-bottom:0;">Edit Book</h1>
		<h3 style="padding:0;">Here you will find mystery magic and mayhem! </h3>
		<div class="button-wrp">
			<a href="/add/book" class="button">Add Book</a>
		</div>
		<form:form method="post" action="/api/edit/book" modelAttribute="book">
			<div>
				<span>
					<form:label path="title">Title</form:label>
					<form:errors path="title"/>
				</span>
				<form:input path="title" type="text" value="${thisBook.title }"  />
			</div>
			
			<div>
				<span>
					<form:label path="author">Author</form:label>
					<form:errors path="author"/>
				</span>
				<form:input path="author" type="text" value="${thisBook.author }" />
			</div>
			
			<div>
				<span>
					<form:label path="thoughts">Description</form:label>
					<form:errors path="thoughts"/>
				</span>
				<form:input path="thoughts" type="text" value="${thisBook.thoughts }" />
			</div>
			
			<input type="hidden" value="${thisBook.id }" name="book" />	
			<input type="submit" value="Edit Book" class="submit"/>
		</form:form>
	</div>
</body>
</html>
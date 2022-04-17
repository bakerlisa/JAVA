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
<title>Dojos and Ninjas</title>
  <link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
<div class="container">
<nav>
	<a href="/">Home</a> |
	<a href="/add/ninja">Add Ninja</a> |
	<a href="/ninjas"> Ninjas</a> |
	<a href="/add/dojo">Add Dojo</a>
</nav>
	<h1>Dojos and Ninjas</h1>
	
	<c:forEach var="dojo" items="${dojos }">
		<div class="elm">
			<p><a href="/dojo/<c:out value='${dojo.id }'/>"> ${dojo.name } </a></p>
			
			<div class="actions">
				<a href="/edit/dojo/${dojo.id}">Edit </a> 
				|
				<form action='/delete/dojo/<c:out value="${dojo.id}"/>' method="post" class="delete"><input type="hidden" name="_method" value="delete"><input type="submit" value="Delete"></form>
			</div>
		</div>
	</c:forEach>
	
</div>

</body>
</html>
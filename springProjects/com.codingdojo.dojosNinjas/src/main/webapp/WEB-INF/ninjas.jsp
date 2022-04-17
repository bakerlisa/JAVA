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
	<h1> All Ninjas</h1>
		<c:choose>
    		<c:when test="${ninjas.size() == 0 }">
    			<h3>No Ninjas :(</h3>
    		</c:when> 
    	<c:otherwise>	
			<c:forEach var="ninja" items="${ninjas }">
				<div class="ninja-wrp">
					<p><a href="/edit/ninja/${ninja.id }"> ${ninja.firstName } ${ninja.lastName } </a></p>
					<p><a href="/dojo/${ninja.dojo.id }"> ${ninja.dojo.name } </a></p>
					<form action='/delete/ninja/<c:out value="${ninja.id}"/>' method="post" class="delete"><input type="hidden" name="_method" value="delete"><input type="submit" value="Delete"></form>
				</div>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	
</div>

</body>
</html>
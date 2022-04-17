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
	<a href="/">Dash</a> |
	<a href="/add/person">Add Person</a> |
	<a href="/add/license">Add License</a> 
</nav>
	<h1>Home</h1>
	<h3>All People | <a href="/licenses">All License</a></h3>
 	<c:choose>
    		<c:when test="${people.size() == 0 }">
    		<h3>Friends Songs Yet Added!</h3>
    		</c:when> 
    		   
    		<c:otherwise>
    		<div class="elm titles">
				<p class="name">Name</p>
				<p class="rating">License</p>
				<p class="actions">Action</p>			
			</div>
			
			<c:forEach var="person" items="${people}">
				<div class="elm">
					<p class="name"><a href="/people/<c:out value="${person.id}"/>"><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></a></p>
					<p class="licenes"><c:out value="${person.license.number}"/> - <c:out value="${person.license.state}"/></p>
					<div class="actions">
						<a href="/edit/<c:out value="${person.id}"/>" class="edit">Edit</a> | 
						<form action='/delete/<c:out value="${person.id}"/>' method="post" class="delete"><input type="hidden" name="_method" value="delete"><input type="submit" value="Delete"></form>  
					</div>
				</div>
			</c:forEach>
    			
    		</c:otherwise>
		</c:choose>

	</div>
</body>
</html>
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
	<h1>All Licenses</h1>
	
 	<c:choose>
    		<c:when test="${license.size() == 0 }">
    		<h3>Oh No! No one can Drive!</h3>
    		</c:when> 
    		   
    		<c:otherwise>
    		<div class="elm titles">
    			<p class="state">State</p>
				<p class="number">Number</p>
				<p class="id">Person ID</p>
				<p class="actions">Action</p>			
			</div>
			
			<c:forEach var="lic" items="${license}">
				<div class="elm">
				<p class="state"><c:out value="${lic.state}"/></p>
					<p class="name"><a href="/people/<c:out value="${lic.id}"/>"> <c:out value="${lic.number}"/> <c:out value="${person.lastName}"/></a></p>
					
					<p class="licenes"><a href="/people/<c:out value="${lic.person.id}"/>"><c:out value="${lic.person.firstName}"/> <c:out value="${lic.person.lastName}"/></a></p>
					<div class="actions">
						<a href="/edit/<c:out value="${lic.id}"/>" class="edit">Edit</a> | 
						<form action='/delete/<c:out value="${lic.id}"/>' method="post" class="delete"><input type="hidden" name="_method" value="delete"><input type="submit" value="Delete"></form>  
					</div>
				</div>
			</c:forEach>
    			
    		</c:otherwise>
		</c:choose>

	</div>
</body>
</html>
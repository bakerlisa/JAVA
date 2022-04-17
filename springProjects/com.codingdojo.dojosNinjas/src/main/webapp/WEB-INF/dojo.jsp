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
	<h1>Dojos - ${dojo.name}</h1>
	
	<c:choose>
    		<c:when test="${dojo.ninjas.size() == 0 }">
    		<h3>You need to do some recruiting </h3>
    		</c:when> 
    		   
    		<c:otherwise>
    		<h3>Students Enrolled: ${dojo.ninjas.size()  }</h3>
    		<div class="elm titles ninjasWrp">
				<p class="name">Name</p>
				<p class="age">Age</p>
				<p class="started">Started</p>		
			</div>
			
			<c:forEach var="ninja" items="${dojo.ninjas}">
				<div class="elm ninjasWrp">
					<p class="name"><a href="/people/<c:out value="${ninja.id}"/>"><c:out value="${ninja.firstName}"/> <c:out value="${ninja.lastName}"/></a></p>
					<p class="age">${ninja.age}</p>
					<p class="started"> <fmt:formatDate type = "both" pattern = "MMMM, dd yyyy" 
         value = "${ninja.createdAt}" /></p>
				</div>
			</c:forEach>
    			
    		</c:otherwise>
		</c:choose>
		
</div>
</body>
</html>
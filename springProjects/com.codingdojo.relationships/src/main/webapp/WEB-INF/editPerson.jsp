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
	<h1>Edit: ${person.firstName } ${person.lastName }</h1>
	
</div>
	<div class="container">
	${person.license }
		<p>License Number: ${person.license.number }	</p>
		<p>State: ${person.license.state }	</p>
		<p>Expires: ${person.license.getExpirationDate() }	</p>
		
	</div>

</body>
</html>
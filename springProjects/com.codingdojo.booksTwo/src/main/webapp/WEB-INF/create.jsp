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
<title>Books</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>

<div class="container">
	<h1>Create Books</h1>
	
 	<form:form action="/api/create" method="post" modelAttribute="book">
 	<div>
 		<form:label path="title">Title</form:label>
 		<form:errors path="title" class="error"/>
 		<form:input type="text" path="title"  />
 	</div>
 	
 	<div>
 		<form:label path="description">Description</form:label>
 		<form:errors path="description" class="error"/>
 		<form:input type="text" path="description"  />
 	</div>
 	<div>
 		<form:label path="language">Language</form:label>
 		<form:errors path="language" class="error"/>
 		<form:input type="text" path="language"  />
 	</div>
 	<div>
 		<form:label path="numberOfPages">Pages</form:label>
 		<form:errors path="numberOfPages" class="error"/>
 		<form:input type="number" path="numberOfPages"  />
 	</div>
 	<input type="submit" value="Submit" />
 	</form:form>
</div>

</body>
</html>
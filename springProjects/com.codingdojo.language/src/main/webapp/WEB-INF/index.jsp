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
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="backgrd"></div>
	<div class="container">
		<a href="/languages">Dashboard</a>
		<h1>Dashboard</h1>
	
	
	<div class="titles elm">
		<p class="name">Name</p>
		<p class="creator">Creator</p>
		<p class="verison">Version</p>
		<p class="actions">Actions</p>
	</div>
	<c:forEach var="lang" items="${languages}">
			<div class="elm">
				<p class="name"><a href="/langauge/<c:out value="${lang.id}"/>"><c:out value="${lang.name}"/></a></p>
				<p class="creator"><c:out value="${lang.creator}"/></p>
				<p class="version"><c:out value="${lang.version}"/></p>
				<div class="actions"> 
					<a class="edit" href='/langauge/<c:out value="${lang.id}"/>/edit'>Edit</a>  
					| 
					<form action='/langauge/<c:out value="${lang.id}"/>/delete' method="post" class="delete"><input type="hidden" name="_method" value="delete"><input type="submit" value="Delete"></form> 
				</div>
				
   			</div>
		</c:forEach>
	
	
	<form:form action="/api/create" method="post" modelAttribute="language">
	<div>
		<span>
		<form:label path="name">Name:</form:label>
		<form:errors path="name" class="error"/>
		</span>
			<form:input type="text" path="name"/>
	</div>
	
	<div>
		<span>
		<form:label path="creator">Creator:</form:label>
		<form:errors path="creator" class="error"/>
		</span>
			<form:input type="text" path="creator"/>
	</div>
	
	<div>
		<span>
		<form:label path="version">version:</form:label>
		<form:errors path="version" class="error"/>
		</span>
			<form:input type="number" path="version" step=".01"/>
	</div>
	
	
	<input type="submit" value="submit" class="submit"/>
	</form:form>
	</div>
</body>
</html>
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
			<a href="/dashboard">Dashboard</a> |
			<a href="/add/name">Add Name</a> |
			<a href="/logout">Logout</a>
		</nav>
	<h1>Add Name</h1>
	<h3>Choose Wisely...</h3>
	<div class="flex">
		<form:form method="post" action="/api/add/name" modelAttribute="name">
		<div>
			<span>
				<form:label path="givenname">New Name</form:label>
			</span>
			<form:input path="givenname" type="text" class="givename"/>
			<form:errors path="givenname" class="error"/>
			<p>${error }</p>
		</div>
		
		<div>
			<span>
				<form:label path="gender">Gender</form:label>
			</span>
			<form:select path="gender">
				<form:option value="witcher">Witcher</form:option>
				<form:option value="wizard">Wizard</form:option>
				<form:option value="elf">Elf</form:option>
				<form:option value="dwarf">Dwarf</form:option>
				<form:option value="fairy">Fairy</form:option>
				<form:option value="alien">Alien</form:option>
			</form:select>
			<form:errors path="gender" class="error"/>
		</div>
		
		<div>
			<span>
				<form:label path="orgin">Orgin</form:label>
			</span>
			<form:input path="orgin" type="text" />
			<form:errors path="orgin" class="error"/>
		</div>
		
		<div>
			<span>
				<form:label path="meaning">Meaning</form:label>
			</span>
			<form:input path="meaning" type="text" />
			<form:errors path="meaning" class="error"/>
		</div>
		
			<input type="hidden" name="designation" value="${userName.id }"/>
			<input type="submit" value="Add Name" class="submit"/>
		</form:form>
	</div>
</div>
</body>
</html>
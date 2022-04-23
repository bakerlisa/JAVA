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
</head>
<body>
<div class="container">
	<nav>
		<a href="/dashboard">Dashboard</a> |
		<a href="/add/name">Add Name</a> |
		<a href="/logout">Logout</a>
	</nav>
		
	<h1>Editing: ${currentName.givenname }</h1>
	<h3>I agree this wasn't the best of names :)</h3>
	<div class="flex">
	
	<form:form method="post" action="/api/update/name/${currentName.id }" modelAttribute="name">
		<div>
			<span>
				<form:label path="givenname">Name:</form:label>
			</span>
			
			<form:input path="givenname" disabled="true"  value="${currentName.givenname }"  />
			<form:input path="givenname" type="hidden"  value="${currentName.givenname }"  />
			<form:errors path="givenname" />
		</div>
		
		<div>
			<span>
				<form:label path="gender">Gender</form:label>
			</span>
			<form:select path="gender" value="${currentName.gender }">
				<form:option value="witcher">Witcher</form:option>
				<form:option value="wizard">Wizard</form:option>
				<form:option value="elf">Elf</form:option>
				<form:option value="dwarf">Dwarf</form:option>
				<form:option value="fairy">Fairy</form:option>
				<form:option value="alien">Alien</form:option>
				<form:option value="demi-god">Demi-God</form:option>
				<form:option value="human">Human</form:option>
			</form:select>
			<form:errors path="gender" class="error"/>
		</div>
		
		<div>
			<span>
				<form:label path="orgin">Orgin</form:label>
			</span>
			<form:input path="orgin" type="text" value="${currentName.orgin }" />
			<form:errors path="orgin" class="error"/>
		</div>
		
		<div>
			<span>
				<form:label path="meaning">Meaning</form:label>
			</span>
			<form:input path="meaning" type="text" value="${currentName.meaning }" />
			<form:errors path="meaning" class="error"/>
		</div>
			
		<input type="hidden" name="designation" value="${currentName.designation.id }"/>
		<input type="hidden" name="id" value="${currentName.id }"/>
		<input type="submit" class="submit" value="Update Name"/>
	</form:form> 
	
	
	<form action="/delete/name/${currentName.id}" method="post" class="delete">
    	<input type="hidden" name="_method" value="delete">
    	<input type="submit" value="Delete">
	</form>
	<a href="/dashboard" class="cancel">Cancel</a>
	
	</div>
</div>
<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>
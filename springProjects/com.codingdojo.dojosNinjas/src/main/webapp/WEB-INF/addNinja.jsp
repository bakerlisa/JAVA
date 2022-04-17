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
	<h1>Add Ninjas</h1>
	<form:form method="post" action="/api/add/ninja" modelAttribute="ninja">
		<div>
			<span>
				<form:label path="firstName">First Name</form:label>
				<form:errors path="firstName" class="error" />
			</span>
			<form:input path="firstName" type="text" />
		</div>
		
		<div>
			<span>
				<form:label path="lastName">Last Name</form:label>
				<form:errors path="lastName" class="error" />
			</span>
			<form:input path="lastName" type="text" />
		</div>
		
		<div>
			<span>
				<form:label path="age">Age</form:label>
				<form:errors path="age" class="error" />
			</span>
			<form:input path="age" type="number" />
		</div>
	
		<div>
			<span>
				<form:label path="dojo">Dojo: </form:label>
			</span>
			
			<form:select path="dojo">
				<c:forEach var="dojo" items="${dojos }">
					<option value="${dojo.id }"> ${dojo.name } </option>
				</c:forEach>
			</form:select>
		</div>
		
		<input type="submit" value="Add Ninja" class="submit" />
	</form:form>
	
</div>

</body>
</html>
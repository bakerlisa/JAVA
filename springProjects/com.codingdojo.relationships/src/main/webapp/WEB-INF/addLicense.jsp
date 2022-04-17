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
	<h1>Add License</h1>
	

		<form:form method="post" action="/api/add/license" modelAttribute="license">
			<div>
				<span>
					<form:label path="number">Number</form:label>
					<form:errors path="number" class="error"/>
				</span>
				<form:input path="number" type="text"/>
			</div>
			
			<div>
				<span>
					<form:label path="expirationDate">Expiration Date</form:label>
					<form:errors path="expirationDate" class="error"/>
				</span>
				<form:input path="expirationDate" type="date"/>
			</div>
			
			<div>
				<span>
					<form:label path="state">State</form:label>
					<form:errors path="state" class="error"/>
				</span>
				<form:input path="state" type="text"/>
			</div>
			
			<div>
				<span>
					<form:label path="person">Person</form:label>
					<form:errors path="person" class="error"/>
				</span>
				
				<form:select path="person">
					<c:forEach var="peep" items="${people}">
						 <form:option value="${peep.id}">${peep.firstName} ${peep.lastName}</form:option>
					</c:forEach>
				</form:select>
				
			
			</div>
			
			
			
			<input type="submit" value="Add License" class="submit"/>
		</form:form>
		
	</div>

</body>
</html>
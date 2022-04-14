<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Edit</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="container">
		<h1>Edit: </h1>
			<form:form action="/api/update/" method="post" modelAttribute="expense">
 			<div>
 				<span>
 					<form:label path="title">Title</form:label>
 					<form:errors path="title" class="error"/>
 				</span>
 				<form:input type="text" path="title"  />
 			</div>
 	
 			 <div>
 			 	<span>
 					<form:label path="description">Description</form:label>
 					<form:errors path="description" class="error"/>
 				</span>
 				<form:input type="text" path="description"  />
 			</div>
 	
 			<div>
 				<span>
 					<form:label path="vendor">Vendor</form:label>
 					<form:errors path="vendor" class="error"/>
 				</span>
 				<form:input type="text" path="vendor"  />
 			</div>
 			
 			<div>
 				<span>
 					<form:label path="amount">Amount</form:label>
 					<form:errors path="amount" class="error"/>
 				</span>
 				<form:input type="number" path="amount"  />
 			</div>
 			
 			<div>
 				<span>
 					<form:label path="id">ID</form:label>
 					<form:errors path="id" class="error"/>
 				</span>
 				<form:input type="hidden" path="id"  />
 			</div>
 	
 			<input type="submit" value="Submit" /> 
 		</form:form></div>
	</body>
</html>
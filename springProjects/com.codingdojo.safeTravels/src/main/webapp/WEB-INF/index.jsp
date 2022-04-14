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
<title>Home Page </title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="container">
		<h1>Save Travels!</h1>
		<div class="titleWrp">
			<p class="expense">Expense</p>
			<p class="vendor">Vendor</p>
			<p class="amount">Amount</p>
			<p class="edit">edit</p>
			<p class="delete">delete</p>
		</div>
		
		<c:if test="${empty expenses}">
			<p class="empty">List is currently empty</p>
		</c:if>
		
		<c:forEach var="expense" items="${ expenses }">
			<div class="expenseWrp">
				<p class="expense"><c:out value="${expense.title }"/></p>
				<p class="vendor"><c:out value="${expense.vendor }"/></p>
				<p class="amount">$<c:out value="${expense.amount }"/></p>
				<a href='/expense/edit/<c:out value="${expense.id}"/>' class="edit">edit</a>
				<form action='/expense/delete/<c:out value="${expense.id}"/>' method="post" class="delete">
    				<input type="hidden" name="_method" value="delete">
    				<input type="submit" value="Delete">
				</form>
			</div>
		</c:forEach> 
	
			
		<h2>Add an Expense</h2>
		<form:form action="/api/create" method="post" modelAttribute="expense">
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
 	
 			<input type="submit" value="Submit" /> 
 		</form:form>
 		
	</div>
</body>
</html>
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
		<a href="/dashboard">Dashboard</a>
		<a href="/categories">Categories</a>
		<a href="/products">Products</a>
		<a href="/add/product">Add Product</a>
		<a href="/add/category">Add Category</a>
	</nav>
		<h1><span>Category - </span> ${category.name} </h1>
		
		<form:form method="post" action="/api/product/category" modelAttribute="categoryProduct">

			<form:select path="product">
				<c:forEach var="prod" items="${products }">
					<form:option value="${prod.id}">${prod.name }</form:option>
				</c:forEach>
			</form:select>
			
			<form:input type="hidden" path="category"  value="${category.id}" />
			<%-- <form:input type="hidden" path="name"  value="${category.name}" /> --%>
			
			<input type="submit" class="submit"/>
		</form:form> 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		<c:choose>
  			<c:when test="${category.products.size() == 0}">
				<p>No products</p>
  			</c:when>
  			<c:otherwise>
  				${category.products.size() }
  				<c:forEach var="prod" items="${category.products} ">
					<%-- <p>${ prod.name }</p> --%>
				</c:forEach>
				
			</c:otherwise>
			
		</c:choose>
	</div>
</body>
</html>
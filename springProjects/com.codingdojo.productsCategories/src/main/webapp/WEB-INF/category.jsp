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
<title> Product / Category </title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="container">
		<nav>
			<a href="/dashboard">Dashboard</a>
			<a href="/categorys">Categories</a>
			<a href="/products">Products</a>
			<a href="/add/product">Add Product</a>
			<a href="/add/category">Add Category</a>
		</nav>
		<h1>Category - <span>${category.name }</span></h1>
		<h3>All da products in da  category</h3>
		
		<div class="cateWrp">
			<c:choose>
  				<c:when test="${category.products.size() == 0 }">
  					<h4>No products in this Category. Add product...</h4>
  				</c:when>

  				<c:otherwise>
  					<h4>Products In ${category.name }: </h4>
  					<c:forEach var="pro" items="${ category.products}">
  						<p>${ pro.name } </p>
  					</c:forEach>
  					<h4>Add to Product: </h4>
  				</c:otherwise>
			</c:choose> 
			
			<form:form method="post" action="/api/categorize" modelAttribute="ProductCategory">
				<div>
					<span>
						<form:label path="product">Product</form:label>
						<form:errors path="product" />
					</span>
					
					<form:select path="product">
						<c:forEach var="prod" items="${product }">
							<form:option value="${prod.id }">${prod.name }</form:option> 
						</c:forEach>
					</form:select>
					
				</div>
				
				<form:input type="hidden" path="category" value="${category.id}"/>
				<input type="submit" value="Add to Category" class="submit"/>
			</form:form>
			
		</div>
	</div>
</body>
</html>
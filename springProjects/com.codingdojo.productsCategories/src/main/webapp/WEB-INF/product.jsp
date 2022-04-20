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
		<h1>Product - <span>${product.name }</span></h1>
		<h3> ${product.description } </h3>
		<p class="price">Price: $${product.price }</p>
		
		<div class="cateWrp">
		
			<c:choose>
  				<c:when test="${product.categories.size() == 0 }">
  					<h4>Not in any Categories. Add to...</h4>
  				</c:when>

  				<c:otherwise>
  					<h4>In Category: </h4>
  					<c:forEach var="cat" items="${ product.categories}">
  						<p>${cat.name }</p>
  					</c:forEach>
  					<h4>Add to Category: </h4>
  				</c:otherwise>
			</c:choose>
			
	
			
			<form:form method="post" action="/api/productize" modelAttribute="ProductCategory">
				<div>
					<span>
						<form:label path="category">Product</form:label>
						<form:errors path="category" />
					</span>
					
					<form:select path="category">	
						<c:forEach var="catgory" items="${ cats }">
							<form:option value="${catgory.id}">${ catgory.name}</form:option>
						</c:forEach>
					</form:select>
				</div>
				
				<form:input type="hidden" path="product" value="${product.id}"/>
				<input type="submit" value="Add to Category" class="submit"/>
			</form:form>
		</div>
	</div>
</body>
</html>
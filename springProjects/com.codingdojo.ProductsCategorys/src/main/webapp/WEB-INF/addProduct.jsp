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
		<h1>Add Product</h1>
		
		<form:form action="/api/add/product" method="post"  modelAttribute="product">
			<div>
				<span>
					<form:label path="name">Product Name:</form:label>
					<form:errors path="name" class="error"/>
				</span>
				<form:input path="name" type="text"/>
			</div>
			
			<div>
				<span>
					<form:label path="description">Description:</form:label>
					<form:errors path="description" class="error"/>
				</span>
				<form:input path="description" type="text"/>
			</div>
			
			<div>
				<span>
					<form:label path="price">Price:</form:label>
					<form:errors path="price" class="error"/>
				</span>
				<form:input path="price" type="number" step='0.01'/>
			</div>
			<input type="submit" value="Add Product" class="submit" />
		</form:form>
	</div>
</body>
</html>
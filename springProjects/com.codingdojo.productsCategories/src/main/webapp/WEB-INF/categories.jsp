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
		<h1>Categories</h1>
		<h3>All da categories in the database</h3>
		
		<div class="cateWrp">
			<c:forEach var="item" items="${categories }">
				<p><a href="/category/${item.id}"> ${item.name} </a></p>
			</c:forEach>
		</div>
	</div>
</body>
</html>
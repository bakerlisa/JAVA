<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruity Frutiy Fruit Loops</title>
</head>
<body>
	<div class="container">
		<h1>We're all a little mad here</h1>
		<div class="hats">
		 <c:forEach var="fruit" items="${fruits}">
    		<p><c:out value="${fruit.getName() }"/></p>
    		<p><c:out value="${fruit.getPrice() }"/></p>
		</c:forEach>
		</div>
		<p>Each hat comes with a 100% guarantee to take you on an adventure you'll never forget!</p>
	</div>
</body>
</html>
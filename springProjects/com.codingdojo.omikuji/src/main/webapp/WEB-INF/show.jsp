<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<h1>Show!</h1>
		<p>In less then <c:out value="${number }"/> days, you will be eating <c:out value="${animal }"/> on the beaches of <c:out value="${city }"/> with <c:out value="${name }"/>. When your worst fear happens <c:out value="${fear }"/>...But you will defeat it with a <c:out value="${magic }"/>. Then <c:out value="${name }"/> will give you a job as a <c:out value="${career }"/> where you will make <c:out value="${number }"/> thousand dollars a year, because, you said it, "<c:out value="${sentance }"/>"!</p>
		<a class="back" href="/back">Another prediction!!!</a>		
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Submitted</title>
</head>
<body>
<div class="container">
	<h1>Welcome <c:out value="${name}"/></h1>
	<p><strong>Email:</strong> <c:out value="${email }"/></p>
	<a href="dashboard">Dashboard</a> | <a href="logout">Logout</a> | <a href="formTwo">Form</a>
</div>

</body>
</html>
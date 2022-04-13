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
<title>Indv Book</title>
</head>
<body>
	<div class="container">
		<h1><c:out value="${ book.title }" /></h1>
		<p><c:out value="${book.description }" /></p>
		<p><strong>Pages: </strong> <c:out value="${book.numberOfPages }" /></p>
		<p><strong>Language: </strong> <c:out value="${book.language }" /></p>
		
	</div>
</body>
</html>
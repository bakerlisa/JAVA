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
<title>Smugetor - Edit your Smuget</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<link href="/fontawesome/css/all.css" rel="stylesheet">
</head>
<body class="expense">
    <div class="container"> <!-- Beginning of Container -->
   <nav>
    	<a href="/dashboard" class="logo">SMUGETOR</a>
    	<a href="/settings"><i class="fa fa-cog" aria-hidden="true"></i></a>
    	<a href="/edit/smuget">Edit Smuget(s)</a>
    </nav>
        <h1>Add Expense </h1>
      	
        
        
		
    </div> <!-- End of Container -->
</body>
</html>
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
<title>Smugetor - Personal Dashboard</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="dash">
	<nav>
    	<div>		
    		<a href="/dashboard" class="logo">SMUGETOR</a>
    		<span>${logged.firstName } ${logged.lastName }</span>
    	</div>
    	<div class="navWrp">
    		<a href="/edit/smuget">Edit Smuget(s)</a>
    		<a href="/settings"><i class="fa fa-cog" aria-hidden="true"></i></a>
    		<a href="/logout"><i class="fa fa-sign-out" aria-hidden="true"></i></a>
    	</div>
    </nav>
    <h1>Dash</h1>
    <div class="container"> <!-- Beginning of Container -->
        
      	
        
        
		
    </div> <!-- End of Container -->
    <script type="text/javascript" src="/js/script.js"></script>
</body>
</html>
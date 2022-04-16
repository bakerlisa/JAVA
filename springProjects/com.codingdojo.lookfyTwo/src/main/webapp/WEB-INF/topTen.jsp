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
<title>Title Here</title>
  <link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>

</head>
<body class="">
    <div class="container"> <!-- Beginning of Container -->
      		<nav>		
       		<a href="/dashboard">Dash</a> |
       		<a href="/add/song">Add Song</a> |
       		<a href="/topTen">Top Song's</a>
       		<div class="searchWrp">
				<form method="post" action="/api/search" >
					<input type="text" name="search" />
					<input type="submit" value="Search" />
				</form>
				<p class="error">${error }</p>
			</div>
		</nav>
        <h1>Top 10 - Rating >= 8</h1>
        
        
        <c:forEach var="sing" items="${song}" begin="0" end="9">
			<div class="elm">
				<p class="name"><a href="/song/<c:out value="${sing.id}"/>"><c:out value="${sing.title}"/></a></p>
				<p class="rating"><c:out value="${sing.rating}"/></p>
				<div class="actions">
					<a href="/edit/<c:out value="${sing.id}"/>" class="edit">Edit</a> | 
					<form action='/delete/<c:out value="${sing.id}"/>' method="post" class="delete"><input type="hidden" name="_method" value="delete"><input type="submit" value="Delete"></form>  
				</div>
			</div>
		</c:forEach>
        
        
       
    </div> <!-- End of Container -->
</body>
</html>
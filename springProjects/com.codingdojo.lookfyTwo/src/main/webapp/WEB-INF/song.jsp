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
<body class="singleSong">
    <div class="container"> <!-- Beginning of Container -->
      	<nav>		
       		<a href="/dashboard">Dash</a>
       		<a href="/add/song">Add Song</a>
		</nav>
        <h1 style="padding-bottom:0;"><c:out value="${song.title}"/>!</h1>
        <h3 style="padding-top:0;"><strong><c:out value="${song.artist}"/></strong> - Rating <c:out value="${song.rating}"/> </h3>
        
        <form action='/delete/<c:out value="${song.id}"/>' method="post" class="delete"><input type="hidden" name="_method" value="delete"><input type="submit" value="Delete"></form>
       
    </div> <!-- End of Container -->
</body>
</html>
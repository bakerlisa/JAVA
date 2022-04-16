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
<body>
    <div class="container"> <!-- Beginning of Container -->
      	<nav>		
       		<a href="/dashboard">Dash</a>
       		<a href="/add/song">Add Song</a>
		</nav>
        <h1>Edit Song!</h1>
        
        <form:form action="/api/add/song" method="post" modelAttribute="song">
        	<div>
        		<span>
        			<form:label path="title">Title</form:label>
        			<form:errors path="title" class="error"/>
        		</span>
        		<form:input path="title" type="text"/>
        	</div>
        	
        	<div>
        		<span>
        			<form:label path="artist">Artist</form:label>
        			<form:errors path="artist" class="error"/>
        		</span>
        		<form:input path="artist" type="text"/>
        	</div>
        	
        	<div>
        		<span>
        			<form:label path="rating">Rating: (Lowest 1-10 highest)</form:label>
        			<form:errors path="rating" class="error"/>
        		</span>
        		<form:input path="rating" type="number"/>
        	</div>
        	
        	<input type="submit" value="Add Song" class="submit" />
        </form:form>
    </div> <!-- End of Container -->
</body>
</html>
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
		</nav>
        <h1>Search by Artist: <span><c:out value="${artist }"/></span> </h1>
				Size ${song.size() }
       
        <c:choose>
    		<c:when test="${song.size() > 0 }">
    			<div class="elm titles">
					<p class="name">Title</p>
					<p class="rating">Rating</p>
					<p class="actions">Action</p>			
				</div>
        		<c:forEach var="sing" items="${song}" >
					<div class="elm">
						<p class="name"><a href="/song/<c:out value="${sing.id}"/>"><c:out value="${sing.title}"/></a></p>
						<p class="rating"><c:out value="${sing.rating}"/></p>
						<div class="actions">
							<a href="/edit/<c:out value="${sing.id}"/>" class="edit">Edit</a> | 
							<form action='/delete/<c:out value="${sing.id}"/>' method="post" class="delete"><input type="hidden" name="_method" value="delete"><input type="submit" value="Delete"></form>  
						</div>
					</div>
				</c:forEach>	
    		</c:when> 
    		   
    		<c:otherwise>
    			<h3>Hmmm....didn't seem to find anything for that search. Try again!</h3>
			</c:otherwise>
		</c:choose> 
        
        
       
    </div> <!-- End of Container -->
</body>
</html>
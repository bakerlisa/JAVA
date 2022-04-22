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
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container dash">

		<nav>
			<a href="/dashboard">Dashboard</a> |
			<a href="/add/name">Add Name</a> |
			<a href="/logout">Logout</a>
		</nav>
	<h1>Welcome  <span>${logged.fullName }!</span></h1>
	<h3><u>Main Event</u>: Name vs. Name  @ 7pm MST</h3>
	<p class="subtitle">You don't want your kid to get bullied because you picked the wrong name? VOTE now!</p>
	<div class="flex">
	<h2><span>Baby Names:</span> <span>Votes:</span></h2>
	<c:choose>
  		<c:when test="${names.size() == 0 }">
  			<p>We have no names at the moment, add one!</p>
  		</c:when>

  		<c:otherwise>
			<c:forEach var="nm" items="${names }">
				<div class="elm">	
					<c:set var="votedFor" value="Vote!!"/>
					<c:forEach var="use" items="${nm.user}">
						<c:if test = "${use.id == logged.id }">
         					<c:set var="votedFor" value="You've Voted"/>
     		 			</c:if> 
					</c:forEach>
				<form:form method="post" action="/api/vote"  modelAttribute="vote" >
					<input type="hidden" name=name value="${ nm.id}" />
					<input type="hidden" name="user" value="${ logged.id}" />
					<input class="button vote" type="submit" value="${votedFor }">
				</form:form>
					
					<p class="name"><a href="/name/${nm.id}">${nm.givenname }</a></p>
					<p><strong>Gender:</strong> ${nm.gender }</p>
					<p><strong>Orgin:</strong> ${nm.orgin }</p>
					<p class="size">${ nm.user.size() }</p>
				</div>
			</c:forEach>
  		</c:otherwise>
	</c:choose>
	
	</div>
</div>
<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>
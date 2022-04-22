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
<div class="container singleName">
		<nav>
			<a href="/dashboard">Dashboard</a> |
			<a href="/add/name">Add Name</a> |
			<a href="/logout">Logout</a>
		</nav>
	<h1>${name.givenname }</h1>
	<h3><strong>Meaning: </strong>${name.meaning }</h3>
	<p class="name">Added by: ${name.designation.fullName }</p>
	<p class="gender">Gender: ${name.gender }</p>
	<p class="orgin">Orgin: ${name.orgin }</p>
	
	<c:set var="votedFor" value="false"/>

	<c:forEach var="vt" items="${ name.user}">
		<c:choose>
	  		<c:when test="${vt.id.equals(userName.id)}">
	  			<p class="voted">You've voted for this name!</p>
	  			<c:set var="votedFor" value="true"/>
  			</c:when>
  		</c:choose>
	</c:forEach>
	
	<c:if test = "${votedFor == false}">
		<form:form method="post" action="/api/vote"  modelAttribute="vote" >
			<input type="hidden" name=name value="${ name.id}" />
			<input type="hidden" name="user" value="${ userName.id}" />
			<input class="button vote yes" type="submit" value="Vote!!">
		</form:form>
	</c:if>
	
	
	<p class="total">Total Votes: ${name.user.size() }</p>
	
	<div class="flex">
	
	<hr />
	
	
	<c:choose>
  		<c:when test="${name.designation.id.equals(userName.id) }">
  			<a  href="/edit/name/${name.id}" class="edit">Edit Name</a>
			<form action="/delete/name/${name.id}" method="post" class="delete">
    			<input type="hidden" name="_method" value="delete">
    			<input type="submit" value="Delete">
			</form>
  		</c:when>
  	</c:choose>
	
	</div>
</div>
<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>
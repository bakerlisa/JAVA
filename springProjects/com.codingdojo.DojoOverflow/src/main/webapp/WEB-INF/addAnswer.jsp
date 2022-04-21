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
<html>
<head>
<meta charset="UTF-8">
<title>Dash</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>

	<div class="container">
		<nav>
			<a href="/dashboard">Dashboard</a> |
			<a href="/add/question">Question</a> |
			<a href="/logout">Logout</a>
		</nav>
		
		<h1 style="padding-bottom:0;">Add an Answer!</h1>
		<h3 style="padding:0;">${ question.quest}? </h3>
		
		<c:choose>
  			<c:when test="${tags.size() == 0}">
  			<p class="note"><em>No tags</em></p>
  			</c:when>
 
  			<c:otherwise>
  			<p class="note">Tags:</p>  
				<ul>
					<c:forEach var="li" items="${tags}">
						<li>${li.subject}</li>
					</c:forEach>
				</ul>
  			</c:otherwise>
		</c:choose>
		
		<div>
		<c:choose>
  			<c:when test="${tags.size() > 0}">
  			<h2>Other User Answers:</h2>
				<c:forEach var="an" items="${question.answers}">
					<p>${an.userAnswer }</p>
				</c:forEach>
			</c:when>
		</c:choose>
		</div>
		
		<div class="flex">
		<h2 class="urAnswer">Add Your Answer</h2>
		<form:form method="post" action="/api/add/answer/" modelAttribute="answer">
			<div>
				<span>
					<form:label path="userAnswer">Answer</form:label>
					<form:errors path="userAnswer" class="error"/>
				</span>
				<form:input path="userAnswer" type="text"/>
			</div>
			<input type="hidden" name="question" value="${question.id}" />
			<input type="submit" value="Add Answer" class="submit" />
		</form:form>
		</div>
	</div>

</body>
</html>
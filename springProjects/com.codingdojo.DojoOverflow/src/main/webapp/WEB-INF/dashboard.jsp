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
		
		<h1 style="padding-bottom:0;">Dashboard - <span>${logged.firstName }!</span></h1>
		<h3 style="padding:0;"><strong>Questions</strong>: find answers to mystery magic and mayhem! </h3>
		<div class="flex">
		<c:choose>
  			<c:when test="${questions.size() == 0}">
				<h4 class="center">No questions have been raise! Ask one now</h4>
  			</c:when>

  			<c:otherwise>
  				<div class="elm titles">
  					<p class="qu">Question</p>
  					<p class="tg">Tags</p>
  				</div>
  				
  				<div class="elmpt"> 
  					<c:forEach var="quest" items="${questions}">
						<div class="elm">
							<p class="qu"><a href="/answer/${ quest.id}">${quest.quest }</a></p>
							<c:forEach var="tag" items="${quest.tag}">
								<span>${tag.subject }</span>,
							</c:forEach>
						</div>
					</c:forEach>
				</div>
				
  			</c:otherwise>
		</c:choose>
			
		</div>
	</div>

</body>
</html>
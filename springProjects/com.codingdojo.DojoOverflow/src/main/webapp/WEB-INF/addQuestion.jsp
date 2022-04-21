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
		
		<h1 style="padding-bottom:0;">Add Question!</h1>
		<h3 style="padding:0;">Here you will find mystery magic and mayhem! </h3>
		<div class="flex">
			<form:form action="/api/add/question" method="post" modelAttribute="question">
				<div>	
					<span>
						<form:label path="quest">Question</form:label>
						<form:errors path="quest" class="error"/>
					</span>
					<form:input type="text" path="quest" />
				</div>
				
				<div>	
					<span>
						<form:label path="tag">Tags</form:label>
						<span class="instructions">Atleast 1 tag no more than 3, in a comma seperated list!</span>
						<span class="error">${error }</span>
						<form:errors path="tag" class="error"/>
					</span>
					<form:input type="text" path="tag" />
				</div>
				
				<input type="submit" value="Ask Question" class="submit"/>
			</form:form>
		</div>
	</div>

</body>
</html>
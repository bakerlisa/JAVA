<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Ninja Gold </title>
<link rel="stylesheet" type="text/css" href="/css/styles.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body class="home">
	<div class="container">
		<h1>Ninja Gold</h1>
		<p><strong>Gold:</strong> <c:out value="${gold }"/></p>
		<a href="/reset" class="button">Reset</a>
		
		<div class="goldbox">
			<h4>Farm:</h4>
			<p>Earns 10-20 gold</p>
			
			<form action="/findGold" method="post">
				<input type="hidden" name="type" value="farm" />
				<input type="hidden" name="max" value=10 />
				<input type="hidden" name="min" value=20  />
				<input type="submit" value="Find Gold!" class="buttonOne"/>
			</form>
		</div>
		
		<div class="goldbox">
			<h4>Cave:</h4>
			<p>Earns 10-20 gold</p>
			<form action="/findGold" method="post">
			<input type="hidden" name="type" value="cave" />
				<input type="hidden" name="max" value=10 />
				<input type="hidden" name="min" value=20  />
				<input type="submit" value="Find Gold!" class="buttonOne" />
			</form>
		</div>
		
		<div class="goldbox">
			<h4>House:</h4>
			<p>Earns 10-20 gold</p>
			<form action="/findGold" method="post">
			<input type="hidden" name="type" value="house" />
				<input type="hidden" name="max" value=10 />
				<input type="hidden" name="min" value=20  />
				<input type="submit" value="Find Gold!" class="buttonOne" />
			</form>
		</div>
		
		<div class="goldbox">
			<h4>SPA:</h4>
			<p>Loses 5-20 gold</p>
			<form action="/findGold" method="post">
			<input type="hidden" name="type" value="spa" />
				<input type="hidden" name="max" value=5 />
				<input type="hidden" name="min" value=20  />
				<input type="submit" value="Spend Gold!" class="buttonOne" />
			</form>
		</div>
		
		<div class="goldbox">
			<h4>Quest:</h4>
			<p>Earns/Takes 0-50 gold</p>
			<form action="/findGold" method="post">
			<input type="hidden" name="type" value="quest" />
				<input type="hidden" name="max" value=0 />
				<input type="hidden" name="min" value=50  />
				<input type="submit" value="Gamble Gold!" class="buttonOne" />
			</form>
		</div>
		
		<div class="activitiesWrp">
		<h2>Activities</h2>
		<%java.text.DateFormat weekDay = new java.text.SimpleDateFormat("EEEE "); %>
		<%java.text.DateFormat day = new java.text.SimpleDateFormat("d "); %>
		<%java.text.DateFormat month = new java.text.SimpleDateFormat("MMMM"); %>
		<%java.text.DateFormat year = new java.text.SimpleDateFormat("y "); %>
		<% java.text.DateFormat time = new java.text.SimpleDateFormat("h:mm aa"); %>
		
	
		<c:forEach var="action" items="${actionsMade}">
        	<c:choose>
    			<c:when test="${action.getAmount() > 1}">
        			<p class="pos"> You just received
   				</c:when>    
    		<c:otherwise>
        		<p class="neg"> Bummer..you just spent 
    		</c:otherwise>
		</c:choose>	
        		<c:out value="${action.getAmount() }" /> of gold. From entering <c:out value="${action.getType() }" />
        		( <%= month.format(new java.util.Date()) %> <%= day.format(new java.util.Date()) %> <%= year.format(new java.util.Date()) %> at <%= time.format(new java.util.Date()) %>)</p>
   		</c:forEach>
   		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Ninja Gold</h1>
		<p><strong>Gold:</strong> <c:out value="${gold }"/></p>
		
		<div class="goldbox">
			<h4>Farm:</h4>
			<p>Earns 10-20 gold</p>
			
			<form action="/findGold" method="post">
				<input type="hidden" name="type" value="general" />
				<input type="hidden" name="max" value=10 />
				<input type="hidden" name="min" value=20  />
				<input type="submit" value="Find Gold!" />
			</form>
		</div>
		
		<div class="goldbox">
			<h4>Cave:</h4>
			<p>Earns 10-20 gold</p>
			<form action="/findGold" method="post">
			<input type="hidden" name="type" value="general" />
				<input type="hidden" name="max" value=10 />
				<input type="hidden" name="min" value=20  />
				<input type="submit" value="Find Gold!" />
			</form>
		</div>
		
		<div class="goldbox">
			<h4>House:</h4>
			<p>Earns 10-20 gold</p>
			<form action="/findGold" method="post">
			<input type="hidden" name="type" value="general" />
				<input type="hidden" name="max" value=10 />
				<input type="hidden" name="min" value=20  />
				<input type="submit" value="Find Gold!" />
			</form>
		</div>
		
		<div class="goldbox">
			<h4>Quest:</h4>
			<p>Earns/Takes 0-50 gold</p>
			<form action="/findGold" method="post">
			<input type="hidden" name="type" value="quest" />
				<input type="hidden" name="max" value=0 />
				<input type="hidden" name="min" value=50  />
				<input type="submit" value="Find Gold!" />
			</form>
		</div>
		
		<h2>Activities</h2>
		
	</div>
</body>
</html>
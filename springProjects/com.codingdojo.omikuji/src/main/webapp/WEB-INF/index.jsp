<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container">
		<h1>Omikuji!</h1>
		<p class="subtitle">May the vacation Gods bless you with more time to sit in the sun on a beach drinking Piña Coladas </p>
		
		<form action="/submit" method="post">
			<div>
				<label for="name">Type a name:</label>
				<input type="text" name="name" id="" />
			</div>
			
			<div>
				<label for="number">Number:</label>
				<input type="number" name="number" id="" />
			</div>
			
			
			
			<div>
				<label for="fear">Name a fear:</label>
				<input type="text" name="fear" id="" />
			</div>
			
			<div>
				<label for="city">City with a beach:</label>
				<input type="text" name="city" id="" />
			</div>
			
			<div>
				<label for="career">Career:</label>
				<input type="text" name="career" id="" />
			</div>
			
			<div>
				<label for="animal">Name an animal:</label>
				<input type="text" name="animal" id="" />
			</div>
			
			<div>
				<label for="magic">On your enemies bless them with:</label>
				<select name="magic">
					<option value="curse">Curse</option>
					<option value="spell">Spell</option>
					<option value="wish">Wish</option>
					<option value="luck">Luck</option>
					<option value="blessing">Blessing</option>
					<option value="mystery">Mystery</option>
				</select>
			</div>
			
			<div>
				<label for="sentance">Sentence about yourself:</label>
				<input type="text" name="sentance" id="" />
			</div>
			
			<input type="submit" value="Submit" class="submit"/>
		</form>
	</div>
</body>
</html>
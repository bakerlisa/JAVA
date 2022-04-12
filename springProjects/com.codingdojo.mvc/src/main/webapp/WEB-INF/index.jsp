<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Books</h1>
		
		<!--  Don't have an ID yet. ID placeholder -->
		<form action="/api/books" method="post">
			<div>
				<label for="title">Title:</label>
				<input type="text" name="title" />
			</div>
			
			<div>
				<label for="description">Description:</label>
				<input type="text" name="description" />
			</div>
			
			<div>
				<label for="language">Language:</label>
				<input type="text" name="language" />
			</div>
			
			<div>
				<label for="pages">Number of Pages:</label>
				<input type="number" name="pages" />
			</div>
			
			<input type="submit" value="submit" />
		</form>
	</div>
</body>
</html>
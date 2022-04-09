<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Date</title>
<link rel="stylesheet" type="text/css" href="/css/styles.css">
	<script type="text/javascript" src="/js/date.js"></script>
</head>
<body>

<div class="container">
	<h1>Date</h1>
	<%java.text.DateFormat df = new java.text.SimpleDateFormat("EEEE "); %>
	<%java.text.DateFormat df1 = new java.text.SimpleDateFormat("d "); %>
	<%java.text.DateFormat df2 = new java.text.SimpleDateFormat("MMMM, y "); %>
	
	
	 <p class="blue"> <%= df.format(new java.util.Date()) %> the  <%= df1.format(new java.util.Date()) %> of  <%= df2.format(new java.util.Date()) %> </p>
	<img src="/img/endofworld.jpeg" alt="End of world outfit" class="endWorld" />
	<a href="/">Home</a>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Barlow+Semi+Condensed:wght@300;400;600;800&family=Open+Sans:wght@300&family=Rubik+Moonrocks&display=swap" rel="stylesheet">

<style>
h1,h3,strong{font-family: 'Barlow Semi Condensed', sans-serif;
font-family: 'Rubik Moonrocks', cursive;}
span,p{font-family: 'Open Sans', sans-serif;}
.wrapper{max-width:700px; padding:25px; margin:0 auto; background-color:rgba(255,255,255,.5); position:Absolute;  transform:translateY(-50%);top:50%; left:0; right:0;}
</style>
</head>
<body style="background-image: url('/colour-1885352_1920.jpg');">
	<div class="wrapper">
	<h1>Cursomer Name: <c:out value="${name}"/></h1>
	<h3>Item Name: <span><c:out value="${itemName }"/></span></h3>
	<p><strong>Price</strong>: $<c:out value="${price }"/> million</p>
	<p><strong>Description</strong>: <c:out value="${description }"/></p>
	<p><strong>Vendor</strong>: <c:out value="${ vendor}" /></p>
	</div>
</body>
</html>
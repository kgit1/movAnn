<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/resources/css/main.css">
<title>Movies</title>
</head>
<body>
<div class="main">
<p><a href="${pageContext.request.contextPath}/movies/list">MAIN</a></p>
<table>
<tr><th colspan="4">TOP MOVIES</th></tr>
<tr>
<th>Id</th>
<th>Title</th>
<th>Director</th>
<th>Year</th>
</tr>
<c:forEach var="movie" items="${movie1}">
<tr>
<td>${movie.id}.</td>
<td>${movie.title}</td>
<td>${movie.director}</td>
<td>${movie.year}</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<p style="text-align:right;color:red;font-size:0.8em">ver20Nov2016</p>
<p><a href="http://c1-kongfly.rhcloud.com/2/">PREVIOUS MAIN</a></p>
New Content here

<p><a href="showFormMovies" class="button">Add Movie</a>
<a href="showMovie" class="button">Show Movie</a></p>
<form action="showMovieByYear">
<input type="text" name="year"/>
<input type="submit" value="Show" class="save"/>
</form>


<table class="del">
<tr><td>by Id</td><td><form action="showMovieById">
<input type="text" name="id"/>
<input type="submit" value="Show" class="save"/>
</form></td>
<td>by Title</td><td><form action="showMovieByTitle">
<input type="text" name="title"/>
<input type="submit" value="Show" class="save"/>
</form></td></tr>
<tr><td>by Director</td><td><form action="showMovieByDirector">
<input type="text" name="director"/>
<input type="submit" value="Show" class="save"/>
</form></td>
<td>by Year</td><td><form action="showMovieByYear">
<input type="text" name="year"/>
<input type="submit" value="Show" class="save"/>
</form></td></tr>
</table>
<p></p>
<table class="del">
<tr><td>by Id</td><td><form action="deleteMovieById">
<input type="text" name="id"/>
<input type="submit" value="Delete" class="save"/>
</form></td>
<td>by Title</td><td><form action="deleteMovieByTitle">
<input type="text" name="title"/>
<input type="submit" value="Delete" class="save"/>
</form></td></tr>
<tr><td>by Director</td><td><form action="deleteMovieByDirector">
<input type="text" name="director"/>
<input type="submit" value="Delete" class="save"/>
</form></td>
<td>by Year</td><td><form action="deleteMovieByYear">
<input type="text" name="year"/>
<input type="submit" value="Delete" class="save"/>
</form></td></tr>
</table>
<p></p>
<table>
<tr><th colspan="4">TOP MOVIES</th></tr>
<tr>
<th>Id</th>
<th>Title</th>
<th>Director</th>
<th>Year</th>
</tr>
<c:forEach var="movie" items="${movies}">
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie form</title>
<link type="text/css" rel="stylesheet"
href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
<div class="main">
<form:form action="saveMovie" modelAttribute="movie" method="POST">
<table>
<tr>
<td><label>Title</label></td>
<td><form:input path="title"/></td></tr>
<tr>
<td><label>Director</label></td>
<td><form:input path="director"/></td></tr>
<tr>
<td><label>Year</label></td>
<td><form:input path="year"/></td></tr>
<tr>
<td><label></label></td>
<td><input type="submit" value="Save" class="save"/></td>
</table>
</form:form>
<div style="clear:both;"></div>
<p><a href="${pageContext.request.contextPath}/movies/list">Back to Movies</a>
</div>


</body>
</html>
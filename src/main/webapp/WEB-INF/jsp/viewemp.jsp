<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<table width="50%" border="2" cellpadding="2" >
	<tr><th>Age</th><th>Name</th><th>Delete</th><th>Update</th></tr>
	<c:forEach var="pojo" items="${list}">
	<tr>
	<td>${pojo.age}</td>
	<td>${pojo.name}</td>
	<td><a href="delete/${pojo.age}">delete</a></td>
	<td><a href="edit/${pojo.age}">Edit</a></td>
	</tr>
	</c:forEach>
	</table>
	<br>
	<h2><a href="index"> Home</a></h2>
</body>
</html>
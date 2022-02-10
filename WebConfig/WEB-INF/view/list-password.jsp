<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passwords ${urlPattern}</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/list-password.css">
</head>
<body>
	<div id="header"></div>
	<div id=content>
		<table border="1px">
			<tr>
				<th>Url</th>
				<th>Identified By</th>
				<th>Username</th>
				<th>Password</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="password" items="${passwords}">
				<tr>
					<td>${password.urlPattern}</td>
					<td>${password.identifiedBy}</td>
					<td>${password.username}</td>
					<td>${password.password}</td>
					<td>
						<a href="${pageContext.request.contextPath}/updatePassword?id=${password.id}">Update</a>
						<a>|</a>
						<a href="${pageContext.request.contextPath}/deletePassword?id=${password.id}" onclick="if(!(confirm('Delete?'))) return false;">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<a href="${pageContext.request.contextPath}/home">Home</a>
</body>
</html>
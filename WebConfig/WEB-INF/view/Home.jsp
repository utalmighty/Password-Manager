<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Passwords Home</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css">
</head>
<body>
	<div id="header">
		<H2>Password Manager</H2>
	</div>
	<div id=content>
		<table border="1px">
			<thead>
				<tr id="headerRow">
					<th>Url</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="url" items="${urls}">
					<tr>
						<td>${url}</td>
						<td><a href="${pageContext.request.contextPath}/passwords?url=${url}">View</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="${pageContext.request.contextPath}/addPassword">Add Password</a>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>${title}</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/form.css">
</head>
<body>
	<div id="header"></div>
	<div id="form">
		<form:form action="${pageContext.request.contextPath}/${redirect}ProcessPassword" modelAttribute="Password">
			
			<form:hidden path="id"/>
			
			Url: <form:input path="urlPattern"/>
			<form:errors path="urlPattern"></form:errors>
			<br><br>
			
			Identified By: <form:input path="identifiedBy"/>
			<form:errors path="identifiedBy"></form:errors>
			<br><br>
			
			Username: <form:input path="username"/>
			<form:errors path="username"></form:errors>
			<br><br>
			
			Password: <form:input path="password"/>
			<form:errors path="password"></form:errors>
			<br><br>
			
			<input type="submit" value = "Submit">
		</form:form>
	</div>
</body>
</html>
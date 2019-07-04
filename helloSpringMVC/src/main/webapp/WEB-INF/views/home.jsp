<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<meta charset="UTF-8">
<head>
	<title>Home</title>
</head>
<body>

	<p> <a href="${pageContext.request.contextPath}/offers"> Show current Offers </a> </p>
	<p> <a href="${pageContext.request.contextPath}/createoffer"> Add a new offer </a> </p>
	
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>
	
	<form id="logout" action="<c:url value="/logout" />" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
</body>
</html>

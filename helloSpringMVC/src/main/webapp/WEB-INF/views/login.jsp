<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Custom Login with Username and Password</h3>
	<!-- login-form 의 username, password parameter의 default 값은 username, password 이다. -->
     <div class="container">
      <form class="form-signin" method="post" action="<c:url value="login"/>">
        <h2 class="form-signin-heading">Please sign in</h2>
        
        <c:if test="${not empty logoutMsg}">
        	<div style="color:#0000ff"> <h3> ${logoutMsg} </h3> </div>
        </c:if>
        
        <c:if test="${not empty errorMsg}">
        	<div style="color:#ff0000"> <h3> ${errorMsg} </h3> </div>
        </c:if>
        
        <p>
          <label for="username" class="sr-only">Username</label>
          <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
        </p>
        <p>
          <label for="password" class="sr-only">Password</label>
          <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <!-- spring security 4 이상부터는 csrf 부분이 true 이므로 반드시 써줘야 한다. -->
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      </form>
	</div>
</body>
</html>
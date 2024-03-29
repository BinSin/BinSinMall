<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-wrapper">
	<div class="container">
		<h1>Register Page</h1>
		<p class="lead">회원 가입</p>

		<sf:form action="${pageContext.request.contextPath}/register" method="post" modelAttribute="user">
		
			<h3>기본 정보</h3>
			
			<div class="form-group">
				<label for="username">아이디</label>
				<span style="color: #ff0000">${usernameMsg}</span>
				<sf:input path="username" id="username" class="form-control" />
				<sf:errors path="username" cssStyle="color:#ff0000" />
			</div>
			
			<div class="form-group">
				<label for="password">패스워드</label>
				<sf:input path="password" type="password" id="password" class="form-control" />
				<sf:errors path="password" cssStyle="color:#ff0000" />
			</div>
			
			<div class="form-group">
				<label for="email">메일 주소</label>
				<sf:input path="email" id="email" class="form-control" />
				<sf:errors path="email" cssStyle="color:#ff0000" />
			</div>
			
			<br/>
			
			<h3>배송 정보</h3>
			
			<div class="form-group">
				<label for="shippingStreet">주소</label>
				<sf:input path="shippingAddress.address" id="shippingStreet" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="shippingCountry">국가</label>
				<sf:input path="shippingAddress.country" id="shippingCountry" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="shippingZip">우편 번호</label>
				<sf:input path="shippingAddress.zipCode" id="shippingZip" class="form-control" />
			</div>
			
			<br/>
			
			<button type="submit" class="btn btn-primary">Submit</button> 
			
			<a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
			
		</sf:form>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
	<!-- modelAttribute : 객체 선택, path : 변수 선택 -->
	<sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="offer">
		<table class="formtable">
			<tr> <td class="label"> Name: </td> <td> <sf:input class="control" type="text" path="name" /> <br/>
				<sf:errors class="error" path="name" /> </td> </tr>
			<tr> <td class="label"> Email: </td> <td> <sf:input class="control" type="text" path="email" /> <br/>
				<sf:errors class="error" path="email" /> </td> </tr>
			<tr> <td class="label"> Text: </td> <td> <sf:textarea class="control" path="text" /> <br/>
				<sf:errors class="error" path="text" /> </td> </tr>
			<tr> <td class="label"> </td> <td> <input class="control" type="submit" value="제출"> </td> </tr>
		</table>
	</sf:form>

</body>
</html>
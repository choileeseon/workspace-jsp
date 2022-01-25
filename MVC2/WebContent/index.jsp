<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 1. browser가 servlet 요청 -->
	<h1>홈 페이지</h1>
	<!-- 1. request.getContextPath()가 /MVC2 이다 2. controller로 이동  -->
	<p><a href="<%=request.getContextPath() %>/Controller?action=login">로그인 페이지로</a>
	<p><a href="<%=request.getContextPath() %>/Controller?action=about">어바웃 페이지로</a>
</body>
</html>
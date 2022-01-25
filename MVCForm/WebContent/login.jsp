<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>로그인 페이지</h1>
<form action="/MVCForm/Controller" method="post"> 
<!-- 왜 controller로 가야하는지? 유효성 검사할때 실패할시 다시 Controller로 가서 검사받아야해서 
만약 loginsuccess로 적는다면 실패해도 로그인성공이 페이지로 가기때문 -->

<input type="hidden" name="action" value="dologin">
<input type="text" name="email" placeholder="email" value="<%=request.getAttribute("email") %>"><br>
<input type="text" name="password" placeholder="password" value="<%=request.getAttribute("password") %>"><br>
<input type="submit" value="전송">
</form>

<h2><%= request.getAttribute("valmessage") %></h2>

</body>
</html>
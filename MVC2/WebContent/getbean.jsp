<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- jsp에 자바 bean 객체만들기 : id는 객체의 이름 / scope는 범위 -->
<jsp:useBean id="user" class="beans.User" scope="page" />

<!-- 자바 bean에 값을 가져오기 (get메소드)-->
이메일 : <%=user.getEmail() %>
패스워드 : <%=user.getPassword() %>
</body>
</html>
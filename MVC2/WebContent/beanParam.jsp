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
<jsp:useBean id="user2" class="beans.User" scope="page" />

<!-- 파라메터를 통해 값을 입력받음 ex) ?email=dltjs0220@naver.com&password=1234-->
<jsp:setProperty property="*" name="user2"/> <!-- 여기서는 값을 입력안하고 파라미터에서 값입력 -->

이메일 : <%= user2.getEmail() %>
패스워드 : <%= user2.getPassword() %> <!--오류가 날 때 전체적으로 문제가 없다면 넘어가기-->

</body>
</html>
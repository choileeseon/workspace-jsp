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
<!-- jsp:useBean id="빈 이름" class="자바빈 파일의 패키지.클래스명" scope="유효범위" -->
<jsp:useBean id="user" class="beans.User" scope="page" />

<!-- 자바 bean에 값을 입력하기 (set메소드) -->
<!--jsp:setProperty name="빈 이름" property="필드명" value="값" -->
<jsp:setProperty property="email" name="user" value="rkrud0220@naver.com"/>
<jsp:setProperty property="password" name="user" value="devil2233"/>

</body>
</html>
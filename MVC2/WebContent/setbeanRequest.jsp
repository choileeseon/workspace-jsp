<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 범위가 request 일때! -->
<!-- jsp에 자바 bean 객체만들기 : id는 객체의 이름 / scope는 범위 -->
<jsp:useBean id="user1" class="beans.User" scope="request" />

<!-- 자바 bean에 값을 입력하기 (set메소드) -->
<jsp:setProperty property="email" name="user1" value="dltjs@google.com"/>
<jsp:setProperty property="password" name="user1" value="1234"/>

<!-- redirect 과 forward 차이점 -->
<!-- redirect는 다른  request : 다른페이지로 이동하는 명령이고 그 url로 이동한다  -->
<!-- forward는 같은 request : 이동한 페이지의 url정보는 알수가 없다 말그대로 건네주기만 한것. -->
<jsp:forward page="getbeanRequest.jsp" />
</body>
</html>
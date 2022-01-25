<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 액션의 주소로 form안에 입력창에 입력한 데이터와 함께 요청 -->
<!-- <form action="/Forms/Controller" method="get"> 은 파라미터에 ?user=kim 값이 전달됨-->
<form action="/Forms/Controller" method="post"> <!-- post는 url주소 뒤에 ?user=kim 이 붙지 않는다. -->

<input type="text" name="user">
<input type="submit" value="전송">


</form>
</body>
</html>
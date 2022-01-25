<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
헬로우!
<!-- jsp:forward page="이동할페이지" -->
<!-- url은 index.jsp로 안바뀌고 forward.jsp그대로 보인다 -->
<jsp:forward page="index.jsp" />
</body>
</html>
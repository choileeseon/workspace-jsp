<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%--page 디렉티브 태그 --%>
<%@ page import="java.util.Date" %>
<%@ page import="gui.TextOutput" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP 기본 페이지</h1>
	<%= new Date() %>
	 <br>
	 <%-- JSP에서 클래스 불러오기 --%>
	 <%-- TextOutput() 자바클래스에 적은 getInfo 글 가져오기--%>
	 <%= new TextOutput().getInfo() %>
</body>
</html>
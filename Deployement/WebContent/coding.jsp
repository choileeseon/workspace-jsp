<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 첫번쨰 --%>
<% for(int i=0; i<5; i++){ %>

<p> 이 태그는 <%=i %>번 반복됩니다. </p>

<% } %>

<%-- 두번째 --%>
<%
String id = request.getParameter("id");

if(id == null){
%>
	<p>id가 입력되지 않았습니다.</p>
<% } else { %>
	<p>id는 <%=id %> 입니다.</p>
<% } %>
</body>
</html>
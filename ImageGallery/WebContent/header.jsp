<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"> 
<!--  jstl을 써서 주소가 바꼇을때를 대비 pageContext.request.contextPath-->
<title>${param.title}</title>
</head>
<body>

<div class="headerWrapper">
	<div class="header">
		<img src="${pageContext.request.contextPath}/images/logo.png" />
		<span id="title" ></span>
	</div>
</div>

<div class="content">


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<c:import url="header.jsp">
	<c:param name="title" value="홈페이지"></c:param>
</c:import>
<sql:setDataSource var="ds" dataSource="jdbc/webshop" />
<sql:query var="results" dataSource="${ds}" sql="select * from images limit 10" /> <!-- sql이 result에 저장 -->

<table class="images">
<c:set var="tablewidth" value="8" />


<c:forEach var="image" items="${results.rows}" varStatus="row"> <!-- rows(리스트)가 한줄씩 한개씩 image에 들어감 -->
	
	<c:if test="${row.index % tablewidth == 0 }"><tr></c:if> 
	
	<!-- 변수설정 : 변수이름을 picName으로 바꿈 -->
	<c:set var="picName" scope="page" value="${image.stem}.${image.image_extension}"></c:set>

	<td>
		<a href="<c:url value="/gallery?action=image&image=${image.id}"></c:url>">
			<img src="${pageContext.request.contextPath}/pics/${picName}">
		</a>		
	</td>
	
	<c:if test="${row.index+1 % tablewidth == 0 }"></tr></c:if> <!-- ??8장이 됐으면 닫힌다. -->
</c:forEach>

</table>


<%-- 동적 컨텐츠(내용)이 들어감  --%>

<c:import url="footer.jsp"></c:import>
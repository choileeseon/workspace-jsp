<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> <!-- 문자열함수 ex)toUpperCase -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<c:import url="header.jsp">
	<c:param name="title" value="단독이미지"></c:param>
</c:import>


<sql:transaction dataSource="jdbc/webshop">

<sql:query var="results" dataSource="${ds}" sql="select * from images where id=?" >
	<sql:param>${param.image}</sql:param>
</sql:query>

<c:set var="image" scope="page" value="${results.rows[0]}" />
<c:set var="picName" scope="page" value="${image.stem}.${image.image_extension}" />
<c:set var="average_ranking" scope="page" value="${image.average_ranking}" />

<!-- action이 "rate"이면 rankings와 averag_ranking을 업데이트한다  -->
<c:if test='${param.action == "rate"}'> <!-- ' "" ' 로 쓴다 " "" " 하면 오류남.-->
	<!-- ????? -->
	<c:set scope="page" var="newRating" 
		value="${(image.average_ranking*image.rankings + param.rating)/(image.rankings+1)}" />
	
	<c:set scope="page" var="average_ranking" value="${newRating}" />
	
	<sql:update sql="update images set average_ranking=?, rankings=? where id=?" >
		<sql:param>${newRating}</sql:param>
		<sql:param>${image.rankings + 1}</sql:param>
		<sql:param>${param.image}</sql:param>
	</sql:update>
	
</c:if>

</sql:transaction>

<!-- 화면표시 -->
<div class="container"> 
    <div class="heading">
    	<!-- 잘라내기-0번 시작해서 1번째 철자까지 잘라 0번째만 대문자로--> <!-- 단어 끝자리가 -1 -->
      <h1><c:out value="${fn:toUpperCase(fn:substring(image.stem,0,1))}${fn:toLowerCase(fn:substring(image.stem,1,-1))}" /></h1>
      <div class="rating">Rated: <fmt:formatNumber value="${average_ranking}" maxFractionDigits="1" /></div> <!-- 평균점수가 소수점 한자리까지 나오도록 fmt씀 -->
    </div>
    <div class="flex-box">
      <div class="picture">
        <div class="imageby">Image by <a href="#">${image.attribution_name}</a></div>
        <img src="${pageContext.request.contextPath}/pics/${picName}">
      </div>
      <div class="rating-radio">
      	<!-- url에 선택한 점수도 나타남 form action = input의 name=action 이 같아서 점수가 나타나는.. -->
      	<form action='<c:url value="/gallery" />' method="post"> <!--get방식으로 해보고 브라우저에 보이니 테스트해보기(post,get이나 처리하는건 같음 Controller에 보면)  -->
			<input type="hidden" name="action" value="rate" />
			<input type="hidden" name="image" value="${image.id}" />			
		        <h3>점수를 선택하기</h3>
		        <div><input type="radio" name="rating" value="5" />5 - 최고! </div>
		        <div><input type="radio" name="rating" value="4" />4 - 좋은작품! </div>
		        <div><input type="radio" name="rating" value="3" />3 - 괜찮음 </div>
		        <div><input type="radio" name="rating" value="2" />2 - 그럭저럭 </div>
		        <div><input type="radio" name="rating" value="1" />1 - 최악 </div>
		        <p>
		        	<input type="submit" name="submit" value="OK">
		        	<button><a href='<c:url value="/gallery?action=home"/>'>돌아가기</a></button>
		        </p>
      	</form>
      </div>
    </div>
  </div>




<%-- 동적 컨텐츠(내용)이 들어감  --%>

<c:import url="footer.jsp"></c:import>
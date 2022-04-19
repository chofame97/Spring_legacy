<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>방명록 목록</h3>

<div id='list-top'>
	<form action="list.bo" method="post">
	<input type="hidden" name='curPage' value="1" />

	<div>
		<ul>
			<li>
				<select name="search" class='w-px90'>
					<option value="all" ${page.search eq 'all' ? 'selected' : '' } >전체</option>
					<option value="title" ${page.search eq 'title' ? 'selected' : '' }>제목</option>
					<option value="content"${page.search eq 'content' ? 'selected' : '' }>내용</option>
					<option value="writer" ${page.search eq 'writer' ? 'selected' : '' }>작성자</option>
				</select>
			</li>
			<li><input type="text" name="keyword" value="${page.keyword }" class='w-px300' /></li>
			<li><a class='btn-fill' onclick="$('form').submit()" >검색</a>
		</ul>	
		<ul>
			<!-- 보여질 목록 개수 지정 -->
			<li>
				<select name="pageList" class='w-px90' onchange="$('form').submit()">
					<option value="10">10개씩</option>
					<option value="15">15개씩</option>
					<option value="20">20개씩</option>
					<option value="25">25개씩</option>
					<option value="30">30개씩</option>					
				</select>
			</li>		
			<!-- 로그인되어 있는 경우 글쓰기 가능 -->
			<c:if test="${not empty loginInfo }">
				<li><a class='btn-fill' href='new.bo'>글쓰기</a></li>
			</c:if>
		</ul>
	</div>
	</form>
</div>
<table>
	<thead>
		<tr>
			<th class='w-px70'>번호</th>
			<th>제목</th>
			<th class='w-px100'>작성자</th>
			<th class='w-px100'>작성일자</th>
			<th class='w-px80'>조회수</th>
			<th class='w-px60'>첨부파일</th>
		</tr>
	</thead>
	<tbody>
		<!-- 조회된 목록이 없을 경우 정보 표시.. -->
		<c:if test="${ empty page.list }">
			<tr>
				<td colspan="6">방명록 정보가 없습니다.</td>
			</tr>
		</c:if>
	
		<c:forEach items="${page.list }" var="vo">
			<tr>
				<td>${vo.no }</td>
				<td class='left'>${vo.title }</td>
				<td>${vo.name }</td>
				<td>${vo.writedate }</td>
				<td>${vo.readcnt }</td>
				<td>${empty vo.filename ? '' : '<img src="imgs/attach.png" class="file-img" />'}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div class='btnSet'>
	<jsp:include page="/WEB-INF/views/include/page.jsp" />
</div>

</body>
</html>



















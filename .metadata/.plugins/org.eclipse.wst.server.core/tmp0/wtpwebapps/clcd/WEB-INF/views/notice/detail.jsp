<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>공지글 안내</h3>
<table>
	<tr>
		<th class='w-px120'>제목</th>
		<td class='left' colspan="5">${vo.title }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${vo.name }</td>
		<th>작성일자</th>
		<td>${vo.writedate }</td>
		<th>조회수</th>
		<td>${vo.readcnt }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td class='left' colspan="5">${fn:replace(vo.content, crlf, '<br>') }</td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td class='left' colspan="5">${vo.filename }
			<c:if test="${not empty vo.filename }"> <!-- 첨부 파일이 없지 않으면 아이콘 표시  -->		
				<a href='download.no?id=${vo.id }'><i class="fa-solid fa-download"></i></a>
			</c:if>
		</td>
	</tr>
</table>
<div class='btnSet'>
	<a class='btn-fill' href='list.no'>목록으로</a>
	
	<!-- 1. 관리자로 로그인 경우에만 수정, 삭제 버튼 표시
	     2. 로그인한 사용자(관리자)가 쓴 글인 경우 -->
	<c:if test="${loginInfo.id eq vo.writer }">
		<a class='btn-fill' href='modify.no?id=${vo.id }'>수정</a>
		<a class='btn-fill' onclick=" if(confirm('정말 삭제?')) { href='delete.no?id=${vo.id}' }">삭제</a>
	</c:if>
</div>
</body>
</html>
















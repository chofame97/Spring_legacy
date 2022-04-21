<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.8/sweetalert2.min.css" rel="stylesheet"> 
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.js"></script>
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
	<a class='btn-fill' 
		href='list.no?curPage=${page.curPage }&search=${page.search}&keyword=${page.keyword}'>목록으로</a>
		<!-- 목록 버튼 클릭시 현재 선택한 페이지 값과 검색 항목 그리고 키워드를 가진 상태에서
			 리스트(목록) 화면으로 이동 -->
			 
	<!-- 1. 관리자로 로그인 경우에만 수정, 삭제 버튼 표시
	     2. 로그인한 사용자(관리자)가 쓴 글인 경우 -->
	<c:if test="${loginInfo.id eq vo.writer }">
		<a class='btn-fill' href='modify.no?id=${vo.id }'>수정</a>
<%-- 		<a class='btn-fill' onclick=" if(confirm('정말 삭제?')) { href='delete.no?id=${vo.id}' }">삭제</a> --%>
		<a class='btn-fill' onclick="notice_delete(${vo.id})">삭제</a>
	</c:if>
	
	<!-- 로그인되어 있는 경우에만 답글 쓰기 가능 -->
	<c:if test="${ ! empty loginInfo }">
		<a class='btn-fill' href='reply.no?id=${vo.id }'>답글쓰기</a>
	</c:if>	
</div>
</body>
<script type="text/javascript">
function notice_delete(id) {
	Swal.fire ({
			title: '정말 삭제 하시겠습니까?',
			text: '다시 되돌릴 수 없습니다. 신중하세요.',
			icon: 'warning',
			showCancelButton: true, 		// cancel 버튼 보이기. 기본은 원래 없음
			confirmButtonColor: '#3085d6', 	// confirm 버튼 색깔 지정
			cancelButtonColor: '#d33', 	// cancel 버튼 색깔 지정
			confirmButtonText: '승인', 	// confirm 버튼 텍스트 지정
			cancelButtonText: '취소', 		// cancel 버튼 텍스트 지정
			reverseButtons: true, 		// 버튼 순서 거꾸로
		}).then(result => {
			// 만약 Promise리턴을 받으면,
			if (result.isConfirmed) { 		// 만약 모달창에서 confirm 버튼을 눌렀다면
				location.href='delete.no?id=' + id;
			}
	}); 
	
	
}

</script>
</html>
















<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:forEach items="${list }" var="vo" varStatus="status">
	${status.index eq 0 ? '<hr>' : ''} 
	<div data-seq = "${vo.id }" class='left'>${vo.name } [${vo.writedate }]
	<!-- 로그인한 사용자가 작성한 댓글인 경우 수정/삭제 버튼.. (가능) -->
	<c:if test="${loginInfo.id eq vo.writer }">
		<span style="float: right;">
			<a class='btn-fill-s btn-modify-save'>수정</a>
			<a class='btn-fill-s btn-delete-cancel'>삭제</a>
		</span>
	</c:if>
		<div class='original'>${fn:replace( fn:replace( vo.content, crlf, '<br>'), lf, '<br>') }</div>
		<div class='modify'></div>
	</div>
	<hr>
</c:forEach>

<script>
$('.btn-modify-save').on('click', function () {
	var $div = $(this).closest('div');
	
	if ( $(this).text() == '수정') {
		var tag = "<textarea style='width:95%; height:90%; resize:none;'>"
		 + $div.children('.original').html().replace(/<br>/g, '\n') + "</textarea>"
		$div.children('.modify').html(tag); 
		
		display($div, false);
	}
	
});


function display($div, mode) {
	// mode : 보기 상태(true), 수정 상태(false)
	// 보기 상태 : 수정/삭제 버튼, 원글 보이게, 수정글 안 보이게
	// 수정 상태 : 저장/취소 버튼, 원글 안 보이게, 수정글 보이게
}


</script>











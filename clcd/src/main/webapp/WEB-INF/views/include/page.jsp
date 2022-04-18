<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class='page_list'> <!-- 페이지 목록(번호)가 표시될 곳 -->

	<c:if test="${page.curBlock gt 1 }">
						<!-- gt    > 와 같은 의미 -->
		<a class='page_prev' title="이전" onclick='go_page(${page.beginPage - page.blockPage})'> < Prev </a>
		<a class='page_first' title="처음" onclick='go_page(1)'>1</a>
		<span>&#183;&#183;&#183;</span>
	</c:if>
	
	<c:forEach var = "no" begin="${page.beginPage }" end="${page.endPage }">
		<!-- 현재 페이지인 경우 -->
		<c:if test="${no eq page.curPage }">
			<span class="page_on">${no }</span>
		</c:if>
		<!-- 현재 페이지가 아닌 경우 -->
		<c:if test="${no ne page.curPage }">
			<a class="page_off" onclick="go_page(${no})">${no }</a>
		</c:if>
	</c:forEach>
	
	<c:if test="${page.curBlock lt page.totalBlock }">
						<!-- lt    <  와 같은 의미 -->
		<span>&#183;&#183;&#183;</span>
		<a class="page_last" title="마지막으로" onclick="go_page(${page.totalPage})">${page.totalPage }</a>
		<a class='page_next' title='다음' onclick="go_page(${page.endPage+1})">Next > </a>
	</c:if>

</div>

<script type="text/javascript">
function go_page(page) {
	$('[name=curPage]').val(page);
	$('form').submit();
}

</script>

<style>
	.page_on, .page_off, .page_next, .page_last, .page_first, .page_prev {
		display : inline-block; line-height: 30px; margin: 0;
	}
	
	.page_on {
		border-radius: 50%;
		background-color: #57343A;
		color: #fff;
		font-weight: bold;
	}
	
	.page_on, .page_off, .page_first, .page_prev, .page_next, .page_last {
		min-width: 22px;
		padding: 0 5px 2px;
	}
	
</style>

















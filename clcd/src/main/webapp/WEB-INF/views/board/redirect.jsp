<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<form methed="post" action="${url }">
	<input type="hidden" name="id" value="${id }" />					<!-- 글의 id -->
	<input type="hidden" name ='search' value="${page.search }" />		<!-- 검색조건 -->
	<input type="hidden" name ="keyword" value="${page.keyword }" /> 	<!-- 검색어 -->
	<input type="hidden" name ="pageList" value="${page.pageList }" /> 	<!-- 페이지당 보여질 목록 수 -->
	<input type="hidden" name ="curPage" value="${page.curPage }" />	<!-- 현재 페이지 -->
	<input type="hidden" name ="viewType" value="${page.viewType }" />	<!-- 게시판 형태 -->
</form>

<script>
	$('form').submit();
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class='center' style='width:800px; margin : 0 auto;'>
	<div class='left' style='height:60px;'>
		<a href='<c:url value="/" />'><img src="imgs/clcd_logo.png" /></a>
	</div>
	<hr>
	<div class='left'>
		<h3>내부적인 오류가 발생했습니다.</h3>
		<pre>빠른 시일내에 오류를 해결해 복구시키도록 하겠습니다.</pre>
		<pre>관련 문의사항은 CLCD 고객센터에 알려주시면 친절하게 안내해 드리겠습니다.</pre>
		${msg }
	</div>

</div>
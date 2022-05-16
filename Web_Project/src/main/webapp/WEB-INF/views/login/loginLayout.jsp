<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인화면</title>
<style type="text/css">
.fftable{
border: 1px solid black;
}

* {
	text-align: center;
	
}

body {
	background-color: blue;
	display : block;
}

.center {
	margin: 0px auto;
	background-color: white;
	width: 500px;
	height: 100%;
	
}

h3 {
    /border-right: 1px solid gray;
 	width: 150px;
	font-size: 20px;
	display: inline-block;
}

.kakao {
	widht:250px;
	height:50px;
}

.naver {
	width:250px;
	height:50px;
}
	
</style>
</head>
<body>
<div class="center">
	<h style="margin-top:10px">이알저알</h>
	<br/><h style="font-size:24px">로그인</h>	
	<br/><button>개인회원</button>	<button>기업회원</button>
	<table class="fftable">				
		<br/><input style="width:450px" type="text" />
		<br/><input style="width:450px" type="text" />
		<button style="width:450px">로그인</button>
		<br/><input type="checkbox">로그인 상태 유지		
		<br/><h3>회원가입</h3><h3>아이디 찾기</h3><h3>비밀번호 찾기</h3> 
	</table>
	<div class="social">
	<img class="kakao" src="imgs/kakao_login_medium_narrow.png" />
	<img class="naver" src="imgs/btn_naver.png" />		
	</div>	
	 Copyright © 2022. erjr. All rights reserved.
</div>	
</body>
</html>
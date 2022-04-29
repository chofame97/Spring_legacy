<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<div class="b-example-divider"></div>
	<div class="op _op" style="position: relative; z-index: 11;">
		<div class="header-content _visual_height m_ratio">
			<div class="text _text_wrap">
				<div class="text-wrap _text fr-view">
					<h1 style="text-align: center;">
						<span style="font-size: 48px; color: rgb(33, 33, 33);">새로운
							아르바이트 패러다임</span>
					</h1>
					<p style="text-align: center;">
						<span style="color: rgb(33, 33, 33);"><br></span>
					</p>
					<p style="text-align: center;">
						<span style="color: rgb(33, 33, 33);"><span
							style="font-size: 64px;">이 &nbsp;알 &nbsp;저 &nbsp;알</span></span>
					</p>
					<p style="text-align: center;">
						<span style="color: rgb(33, 33, 33);"><br></span>
					</p>
					<p style="text-align: center;">
						<span style="color: rgb(33, 33, 33);"><br></span>
					</p>
					<p style="text-align: center;">
						<span style="color: rgb(33, 33, 33);"><span
							style="font-size: 20px;">편하게 아르바이트 쉬고 싶을 때</span></span>
					</p>
					<p style="text-align: center;">
						<span style="font-size: 20px; color: rgb(33, 33, 33);">이알저알을
							이용하세요.</span>
					</p>
					<p style="text-align: center;">
						<br>
					</p>
					<p style="text-align: center;">
						<br>
					</p>
					<p style="text-align: center;">
						<button type="button" class="btn btn-outline-dark btn-lg">App다운로드</button>
					</p>
					<p>
						<br>
					</p>
					<p>
						<br>
					</p>
					<p>
						<br>
					</p>
				</div>
			</div>
		</div>
	</div>




	
	<!-- 사진 슬라이드 -->	
		
	<style>
	ul { width: 700px; }
	li { list-style: none; }
	
	.bxslider img {
	width: 1000px;
	height: 500px;
	margin: 0px auto;
}
	</style>
		
	<link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

  <ul class="bxslider">
      <li><a href="#"><img src="imgs/store.png" alt=""></a></li>
      <li><a href="#"><img src="imgs/cafe.png" alt=""></a></li>
      <li><a href="#"><img src="imgs/cafeteria.png" alt=""></a></li>
  </ul>

<script>
$(document).ready(function () {
    $('.bxslider').bxSlider({
        auto: true, // 자동으로 애니메이션 시작
        speed: 500,  // 애니메이션 속도
        pause: 5000,  // 애니메이션 유지 시간 (1000은 1초)
        mode: 'horizontal', // 슬라이드 모드 ('fade', 'horizontal', 'vertical' 이 있음)
        autoControls: false, // 시작 및 중지버튼 보여짐
        pager: true, // 페이지 표시 보여짐
        captions: true, // 이미지 위에 텍스트를 넣을 수 있음
    });
});
</script>	 

	
	 

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
	integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
	crossorigin="anonymous"></script>
</head>
<body>
	<!-- 상단 메뉴 로그인했을때 -->
	<header class="p-3 mb-3 border-bottom">
		<div class="container">
			<div
				class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
				<a href="/"
					class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
					<img src="imgs/home.png" class="bi me-2" width="50" height="42"
					role="img">
				</a>

				<ul
					class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
					<li><a href="#" class="nav-link px-3 text-dark"><h3>이알저알</h3></a></li>
					<li><a href="#" class="nav-link px-3 text-dark"><h3>알알이구하기</h3></a></li>
					<li><a href="#" class="nav-link px-3 text-dark"><h3>고객센터</h3></a></li>
					<li><a href="#" class="nav-link px-3 text-dark"><h3>커뮤니티</h3></a></li>
				</ul>

				<div class="dropdown">
					<button style="background-color: white;"
						class="border border-white btn btn-light d-block link-dark text-decoration-none dropdown-toggle"
						id="dropdownUser1" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">
						<img style="border: 1px solid gray;" src="imgs/ch.jpg" alt="mdo"
							width="44" height="44" class="rounded-circle">
					</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="#">회원정보</a> <a
							class="dropdown-item" href="#">로그아웃</a>
					</div>
				</div>

			</div>
		</div>
	</header>

	<!-- 상단메뉴 바로아래 선 -->
	<div class="b-example-divider" />

	<!-- 상단 메뉴 로그인 안했을때 -->
	<header class="p-3 mb-3 border-bottom">
		<div class="container">
			<div
				class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
				<a href="/"
					class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
					<img src="imgs/home.png" class="bi me-2" width="50" height="42"
					role="img">
				</a>

				<ul
					class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
					<li><a href="#" class="nav-link px-3 text-dark"><h3>이알저알</h3></a></li>
					<li><a href="#" class="nav-link px-3 text-dark"><h3>알알이구하기</h3></a></li>
					<li><a href="#" class="nav-link px-3 text-dark"><h3>고객센터</h3></a></li>
					<li><a href="#" class="nav-link px-3 text-dark"><h3>커뮤니티</h3></a></li>
				</ul>

				<div class="text-end">
					<button type="button" class="btn btn-outline-warning">로그인</button>
					<button type="button" class="btn btn-outline-warning">회원가입</button>
				</div>
			</div>
		</div>
	</header>

	<div class="b-example-divider"></div>

	<!-- 사진 슬라이드 -->
	<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" src="imgs/qwer.jpeg" alt="First slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="imgs/qwer.jpeg" alt="Second slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="imgs/qwer.jpeg" alt="Third slide">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>



</body>
</html>

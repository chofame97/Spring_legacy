<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원 가입 정보 [ ${method } ]</h3>
성명 : ${name }  <br/>
성별 : ${gender } <br/>
이메일 : ${email } <br/>

<h3>회원 가입 정보 [MemberVO member]</h3>
성명 : ${member.name }<br />
성별 : ${member.gender }<br />
이메일 : ${member.email }<br />
</body>
</html>
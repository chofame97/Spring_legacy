package com.hanul.clcd;

import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import common.CommonService;
import member.MemberServiceImpl;
import member.MemberVO;

@Controller
public class MemberController {

	@Autowired private MemberServiceImpl service;
	@Autowired private CommonService common;
	
	private String naver_client_id = "b8TANmFu7fkkL_ObmdQ_";
	
	// kakao 로그인 API 발급 코드 중 REST API key 값
	private String kakao_client_id = "8ec91996d59572acde63a0d4db4b10b3";
	
	
	// 회원가입 insert 처리
	@RequestMapping ("/join")
	public String member_join(MemberVO vo) {
		
		service.member_join(vo);
		
		return "redirect:/";
	}
	
	
	// 아이디 중복확인 요청
	@ResponseBody
	@RequestMapping ("/id_check")
	public boolean id_check(String id) {
		return service.member_id_check(id);
	}
	
	
	
	// 회원가입 페이지 화면 요청
	@RequestMapping ("/member")
	public String member(HttpSession session) {
		// 타이틀에 회원가입이라는 문구를 보여주기 위해서
		session.setAttribute("category", "join");
		return "member/join";
	}
	
	// 카카오 로그인 요청
	@RequestMapping("/kakaoLogin")
	public String kakaoLogin (HttpSession session) {
		
		String state = UUID.randomUUID().toString();
		
		session.setAttribute("state", state);
		
	// https://kauth.kakao.com/oauth/authorize?response_type=code
	// &client_id=${REST_API_KEY}
	// &redirect_uri=${REDIRECT_URI}
		StringBuffer url = new StringBuffer("https://kauth.kakao.com/oauth/authorize?response_type=code");
		url.append("&client_id=").append(kakao_client_id);
		url.append("&state=").append(state);
		url.append("&redirect_uri=http://localhost/clcd/kakaocallback");		
		return "redirect:" + url.toString();
	}
	
	// 카카오 로그인 콜백(Redirect) 요청
	
	@RequestMapping ("/kakaocallback")
	public String kakaocallback(HttpSession session, String code, String state, String error) {
		
		if ( !state.equals(session.getAttribute("state")) || error != null ) {
			return "redirect:/"; 
		}
		
		
		// 접근 토근발급 요청 : 토큰받기 (Sample - Request)
//		curl -v -X POST "https://kauth.kakao.com/oauth/token" \
//		 -H "Content-Type: application/x-www-form-urlencoded" \
//		 -d "grant_type=authorization_code" \
//		 -d "client_id=${REST_API_KEY}" \
//		 --data-urlencode "redirect_uri=${REDIRECT_URI}" \
//		 -d "code=${AUTHORIZE_CODE}"
		
		StringBuffer url = new StringBuffer("https://kauth.kakao.com/oauth/token?grant_type=authorization_code");
		url.append("&client_id=").append(kakao_client_id);
		url.append("&redirect_uri=http://localhost/clcd/kakaocallback");
		url.append("&code=").append(code);
		
		JSONObject json = new JSONObject(common.requestAPI(url));
		
		String type = json.getString("token_type");
		String token = json.getString("access_token");
		
//		문서 - 사용자 정보 가져오기 부분 에서
		
//		Request: 액세스 토큰 사용하여 모든 정보 받기
//		curl -v -X GET "https://kapi.kakao.com/v2/user/me" \
//		  -H "Authorization: Bearer ${ACCESS_TOKEN}"
		
		url = new StringBuffer("https://kapi.kakao.com/v2/user/me");
		
		json = new JSONObject(common.requestAPI(url, type + " " + token));
		
		if (! json.isEmpty() ) {	// json 안에 값이 있다면.. 저장처리..
			MemberVO vo = new MemberVO();
			vo.setSocial_type("kakao");
			vo.setId(json.get("id").toString() );
			
			json = json.getJSONObject("kakao_account");
			vo.setSocial_email( json.getString("email") ) ;
			
			vo.setName( json.getJSONObject("profile").getString("nickname") );
			vo.setGender( json.has("gender") && json.getString("gender").equals("female") ? "여" : "남");
			
			// 카카오 최초 로그인인 경우 회원 정보 저장 (insert)
			// 카카오 로그인 이력이 있어 회원정보가 있다면 변경 저장
			if ( service.member_social_email(vo) )
				service.member_social_update(vo);
			else 
				service.member_social_insert(vo);
			
			// vo 에 담은 데이터를 session 의 loginInfo 에 담음
			session.setAttribute("loginInfo", vo);
		}
		
//		{
//		    "id":123456789,
//		    "kakao_account": { 
//		        "profile_needs_agreement": false,
//		        "profile": {
//		            "nickname": "홍길동",
//		            "thumbnail_image_url": "http://yyy.kakao.com/.../img_110x110.jpg",
//		            "profile_image_url": "http://yyy.kakao.com/dn/.../img_640x640.jpg",
//		            "is_default_image":false
//		        },
//		        "name_needs_agreement":false, 
//		        "name":"홍길동",
//		        "email_needs_agreement":false, 
//		        "is_email_valid": true,   
//		        "is_email_verified": true,
//		        "email": "sample@sample.com",
//		        "age_range_needs_agreement":false,
//		        "age_range":"20~29",
//		        "birthday_needs_agreement":false,
//		        "birthday":"1130",
//		        "gender_needs_agreement":false,
//		        "gender":"female"
//		    },  
//		    "properties":{
//		        "nickname":"홍길동카톡",
//		        "thumbnail_image":"http://xxx.kakao.co.kr/.../aaa.jpg",
//		        "profile_image":"http://xxx.kakao.co.kr/.../bbb.jpg",
//		        "custom_field1":"23",
//		        "custom_field2":"여"
//		        ...
//		    }
//		}
		
		return "redirect:/";
	}
	
	// 네이버 로그인 요청
	@RequestMapping ("/naverLogin")
	public String naverLogin( HttpSession session ) {
		
		// 3.4.2 네이버 로그인 연동 URL 생성하기 
		String state = UUID.randomUUID().toString();
		
		// state 정보를 session 범위 내에서 계속 사용해야 하므로 session 에 담음
		session.setAttribute("state", state);
		
		
		// https://nid.naver.com/oauth2.0/authorize?response_type=code
		// &client_id=CLIENT_ID
		// &state=STATE_STRING
		// &redirect_uri=CALLBACK_URL
		
		StringBuffer url = new StringBuffer("https://nid.naver.com/oauth2.0/authorize?response_type=code");
		url.append("&client_id=").append(naver_client_id);
		url.append("&state=").append(state);
		url.append("&redirect_uri=http://localhost/clcd/navercallback");
		System.out.println(url.toString());
		return "redirect:" + url.toString();
				
	}
	
	// 네이버 로그인 콜백 요청
	@RequestMapping ("/navercallback")
	public String navercallback(@RequestParam(required = false) String code, String state
			, @RequestParam(required = false) String error, HttpSession session ) {
		
		// state 값이 맞지 않거나 error가 발생해도 토큰 발급 불가
		if ( !state.equals(session.getAttribute("state")) || error != null ) {
			return "redirect:/";	// 메인 페이지로 이동
		}
		
		// 개발 가이드 3.4.4 접근 토큰 발급 요청 참조
		
		// 접근 토큰 발급을 위한 요청문 샘플을 복사하여 붙여넣기...
		// https://nid.naver.com/oauth2.0/token?grant_type=authorization_code
		// &client_id=jyvqXeaVOVmV
		// &client_secret=527300A0_COq1_XV33cf
		// &code=EIc5bFrl4RibFls1
		// &state=9kgsGTfH4j7IyAkg
		
		StringBuffer url = new StringBuffer("https://nid.naver.com/oauth2.0/token?grant_type=authorization_code");
		url.append("&client_id=").append(naver_client_id);
		url.append("&client_secret=3RAjYknyEX");
		url.append("&code=").append(code);
		url.append("&state=").append(state);
		
		// 3.4.5 접근 토큰을 이용하여 프로필 API 호출하기
		JSONObject json = new JSONObject(common.requestAPI(url));
		String token = json.getString("access_token");
		String type = json.getString("token_type");
		
//		curl  -XGET "https://openapi.naver.com/v1/nid/me" \
//	      -H "Authorization: Bearer AAAAPIuf0L+qfDkMABQ3IJ8heq2mlw71DojBj3oc2Z6OxMQESVSrtR0dbvsiQbPbP1/cxva23n7mQShtfK4pchdk/rc="
		
		url = new StringBuffer("https://openapi.naver.com/v1/nid/me");
		json = new JSONObject(common.requestAPI(url, type + " " + token));
		
		if (json.getString("resultcode").equals("00")) {
			json = json.getJSONObject("response");
			
			// 회원정보를 DB에 담기 위해서 회원정보 데이터객체를 생성
			MemberVO vo = new MemberVO();
			// 소셜 로그인 형태를 담음.
			vo.setSocial_type("naver");
			vo.setId(json.getString("id"));
			vo.setSocial_email(json.getString("email"));
			vo.setName(json.getString("name"));
			vo.setGender(json.has("gender") && json.getString("gender").equals("F") ? "여" : "남");
			
			// 네이버 최초 로그인인 경우 회원 정보 저장 (insert)
			// 네비어 로그인 이력이 있어 회원정보가 있다면 변경 저장
			if ( service.member_social_email(vo) )
				service.member_social_update(vo);
			else 
				service.member_social_insert(vo);
			
			// vo 에 담은 데이터를 session 의 loginInfo 에 담음
			session.setAttribute("loginInfo", vo);
		}
		
//		{
//			"resultcode": "00",
//			"message": "success",
//			"response": {
//			    "email": "openapi@naver.com",
//			    "nickname": "OpenAPI",
//			    "profile_image": "https://ssl.pstatic.net/static/pwe/address/nodata_33x33.gif",
//			    "age": "40-49",
//			    "gender": "F",
//			    "id": "32742776",
//			    "name": "오픈 API",
//			    "birthday": "10-01"
//			}
//		}
		
		return "redirect:/"; 	// 로그인 시 루트(home.jsp)로 이동
	}
	
	
	
	// 로그아웃 처리 요청
	@RequestMapping ("/logout")
	public String logout(HttpSession session) {
		// 세션에 담긴 로그인 정보를 삭제함.
		session.removeAttribute("loginInfo");
		
		return "redirect:/"; 	// 로그아웃 시 루트(home.jsp) 이동
	}
	
	
	// 로그인 처리 요청
	@ResponseBody
	@RequestMapping ("/memberLogin")
	public boolean login(String id, String pw, HttpSession session) {
		// 화면에서 전송한 아이디, 비밀번호가 일치하는 회원정보를 DB에서 조회
		// 매개변수 2개를 HashMap 형태로 담아 service에 전달
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);		
		MemberVO vo = service.member_login(map);
		
		session.setAttribute("loginInfo", vo);
		
		return vo == null ? false : true;	// 결과값(vo)이 null이면 false / null이 아니면 true		
	}
	
	
	// 로그인 화면 요청
	@RequestMapping ("/login")
	public String login(HttpSession session) {
		session.setAttribute("category", "login");
		return "member/login";
	}
}











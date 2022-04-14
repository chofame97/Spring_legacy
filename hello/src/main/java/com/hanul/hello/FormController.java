package com.hanul.hello;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.MemberVO;

@Controller
public class FormController {

	// ① HttpServletRequest 의 타입으로 파라미터 접근
	
	@RequestMapping ("/joinRequest")
	public String member(HttpServletRequest request, Model model) {
		// 클라이언트가 요청한 값을 받는다.
		model.addAttribute("name", request.getParameter("name") );
		model.addAttribute("gender", request.getParameter("gender") );
		model.addAttribute("email", request.getParameter("email") );
		model.addAttribute("method", "HttpServletRequest");
		return "member/info";
	}
	
	// ② @RequestParam 의 타입으로 파라미터 접근
	@RequestMapping ("/joinParam")
//	public String member(Model model, @RequestParam String name, String gender, String email) {
	public String member(Model model, String name, String gender, String email) {
		
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("email", email);
		model.addAttribute("method", "@RequestParam");
		
		return "member/info";
	}
	
	// ③ 데이터객체(VO)로 파라미터 접근
	@RequestMapping ("/joinDataObject")
	public String member(Model model, MemberVO vo) {
		model.addAttribute("member", vo);
		return "member/info";
	}
	
	// ④ @PathVariable 로 데이터 접근
	@RequestMapping ("/joinPath/{name}/{gender}/{email}")
	public String member(@PathVariable String name, String gender, String email, Model model ) {
		
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("email", email);		
		model.addAttribute("method", "@PathVariable");		
		
		return "member/info";
	}
	
	// 로그인(/login_result) 처리 요청
	@RequestMapping ("/login_result")
	public String login(String id, String pw) {
		// id는 'hong' , pw 는 '1234' 라고 했을 때
		// 일치시 루트("/") 화면으로 불일치시 로그인("/login") 화면으로 연결하시오.
		if (id.equals("hong") && pw.equals("1234")) {
		//	return "redirect:/";		// redirect 방식
			return "home";				// forward 방식
		} else {
		//	return "redirect:/login";	// redirect 방식
			return "member/login";		// forward 방식
		}
		
	}
	
	
	// 로그인 페이지(화면) 요청
	@RequestMapping ("/login")
	public String login() {
		return "member/login";
	}
		
	
	@RequestMapping ("/member")	
	public String member() {
		return "member/join";
	}
	
	
	@RequestMapping("/count")
	public String count() {
		return "count";
	}
	
}







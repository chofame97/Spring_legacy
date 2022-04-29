package com.hm.test;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	// 메인 페이지
	@RequestMapping("/")
	public String home() {
		
		return "main";
	}
	// 알알이 구하기 이동
	@RequestMapping("/searchArAr")
	public String searchArAr() {
		
		return "menu2/searchArAr";
	}
	// 고객센터 이동
	@RequestMapping("/serviceCenter")
	public String serviceCenter() {
		
		return "menu2/serviceCenter";
	}
	// 고객센터 이동
	@RequestMapping("/Community")
	public String community() {
		
		return "menu2/Community";
	}
	// 로그인
	@RequestMapping("/login")
	public String login() {
		
		return "goLogin";
	}
	
	
}

package com.hanul.hello;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 컨트롤러 객체 생성 @Controller
@Controller
public class TestController {

	// 어떤 요청에 대해 연결할 것인지 지정 @RequestMapping()
	// 어노테이션이 올바르게 되었을 때와 아닐 때의 404 에러 메시지가 다름.
	@RequestMapping ("/first")
	public String view(Model model) {
		// model.addAttribute("속성명", 전달한 데이터);
		// 위와 같이 전달된 데이터는 EL 로 표현 가능
		model.addAttribute("today", new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date()) );
		
		return "index";	//  "/first"란 요청에 대해 index.jsp로 응답
	}
	
	@RequestMapping ("/second")
	public ModelAndView view() {
		// ModelAndView 객체를 생성함		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("now", new SimpleDateFormat("a hh시 mm분 ss초").format(new Date()));
		
		// "/second"가 index.jsp로 연결되게끔 지정
		mav.setViewName("index");
		
		return mav;
		
	}
	
	
	
	
	
	
	
	
	
	
}

package com.hanul.exam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExamContoller {
	
	@RequestMapping ("/first")
	public String view(Model model) {
		// 메소드 실행부 (처리부)
		// 화면에 값을 전달할 때 Model 을 이용
		
		model.addAttribute("val", "first 요청에 따른 model 을 통해 값을 index 화면에 전달함");
		
		
		return "index";
	}
	
}

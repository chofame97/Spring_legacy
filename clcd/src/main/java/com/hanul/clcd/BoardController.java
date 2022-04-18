package com.hanul.clcd;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	// 방명록 목록화면 요청
	@RequestMapping("/list.bo")
	public String list(HttpSession session) {
		session.setAttribute("category", "bo");
		return "board/list";
	}
	
	
}

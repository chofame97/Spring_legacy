package com.and.mid;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import member.MemberDAO;
import member.MemberVO;

@Controller
public class MemberController {
	@Autowired MemberDAO dao;
	Gson gson = new Gson();
	
	@Autowired @Qualifier("hanul") private SqlSession sql;
	// 멤버 콘트롤러에 login이라는 맵핑을 만들고 해당하는 맵핑까지 크롬으로 접근하기
	@ResponseBody
	@RequestMapping(value = "/login", produces = "application/json;charset=UTF-8")
	public String login(HttpServletRequest req) {
		MemberVO  vo = new MemberVO();
		vo.setId(req.getParameter("id"));
		vo.setPw(req.getParameter("pw"));
		vo = dao.login(vo);
		return gson.toJson(vo);
		
	}
	
	
	
	
}

package com.and.mid;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;


@Controller
public class CustomerController {
	@Autowired @Qualifier("hanul") private SqlSession sql;
	Gson gson = new Gson();
	@ResponseBody
	@RequestMapping(value = "/cus", produces = "application/json;charset=UTF-8")
	public String login() {
		CusDTO cusdto = new CusDTO();
		CusDTO rel = sql.selectOne("member.mapper.login",cusdto);
		return gson.toJson(rel);
	}
	

}

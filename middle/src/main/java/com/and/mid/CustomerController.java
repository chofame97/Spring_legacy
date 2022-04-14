package com.and.mid;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import customer.CusDTO;


@Controller
public class CustomerController {
	

	@Autowired @Qualifier("hanul") SqlSession sql;
	Gson gson = new Gson();
	//1. Spring에서 컨트롤러를 추가하고 해당하는 맵핑까지 정상적으로 오는지 URL테스트.
	// (localhost/mid/list.cu) ↓
	
	
	// sql.selectone 1건 조회
	// sql.seleclist 여러건 조회
	@ResponseBody
	@RequestMapping(value ="/list.cu", produces = "application/json;charset=UTF-8")
	public String login() {
		System.out.println(sql.selectOne("cus.mapper.test")+"");
		List<CusDTO> list = sql.selectList("cus.mapper.list");
		/*
		 * for(CusDTO cusDTO : list) { System.out.println(cusDTO.getId()); }
		 */
		System.out.println(gson.toJson(list));
		return gson.toJson(list);
	}
	
	@ResponseBody
	@RequestMapping(value ="/update.cu", produces = "application/json;charset=UTF-8")
	public String update(HttpServletRequest req) {
		System.out.println(req.getParameter("dto"));
		CusDTO dto = gson.fromJson(req.getParameter("dto"), CusDTO.class);
		List<CusDTO> list = sql.selectList("cus.mapper.update",dto);
		
		
		
		System.out.println(gson.toJson(list));
		
		return "";
	}
	@ResponseBody
	@RequestMapping(value ="/delete.cu", produces = "application/json;charset=UTF-8")
	public String delete(HttpServletRequest req) {
		System.out.println(req.getParameter("dto"));
		CusDTO dto = gson.fromJson(req.getParameter("dto"), CusDTO.class);
		List<CusDTO> list = sql.selectOne("cus.mapper.delete",dto);
		
	
		
		System.out.println(list);
		
		return "";
	}
	
	
}

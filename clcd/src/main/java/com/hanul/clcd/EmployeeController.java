package com.hanul.clcd;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import employee.EmployeeServiceImpl;
import employee.EmployeeVO;

@Controller
public class EmployeeController {

	@Autowired private EmployeeServiceImpl service;
	
	// DB에서 선택한 사원의 상세 정보 조회 요청
	@RequestMapping ("/detail.hr")
	public String detail(int id, Model model) {
		
		model.addAttribute("vo", service.employee_detail(id) );
		return "employee/detail";
	}
	
	
	// 사원 목록 화면 요청
	@RequestMapping ("/list.hr")
	public String list(HttpSession session, Model model, String dept_name) {
		session.setAttribute("category", "hr");
		
		// 사원이 소속된 부서명 목록을 조회해와 목록화면에 출력
		model.addAttribute("depts", service.employee_department() );
		model.addAttribute("dept_id", dept_name);
		
		if (dept_name == null || dept_name.equals("all")) {
			// DB에서 전체 사원 목록 조회
			List<EmployeeVO> list = service.employee_list();
			model.addAttribute("list", list);
		} else {
			// 선택한 해당 부서명의 사원 목록 조회
			model.addAttribute("list", service.employee_list(dept_name));
		}
		return "employee/list";
	}
}











package com.hanul.clcd;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import customer.CustomerServiceImpl;
import customer.CustomerVO;

// 고객관리 페이지처리 @Controller 생성

// 클라이언트의 요청 → Controller → Service → DAO → mapper  (DB)
//					 ←			   ←		  ←	 ←		

@Controller
public class CustomerController {
	
	@Autowired private CustomerServiceImpl service;
	// Autowired : 메모리에 올려둔 주소들이 자동으로 연결이 됨.
	
	// DB에서 id에 해당하는 고객 정보 삭제 요청
	@RequestMapping ("/delete.cu")
	public String delete(int id) {
		// 선택한 고객 정보를 DB에서 삭제 후 목록 화면으로 연결
		service.customer_delete(id);
		return "redirect:list.cu";  // 삭제 후 갱신된 목록 처리 -> list.jsp
	}
	
	// DB에서 id에 해당하는 고객 정보 수정 요청  
	@RequestMapping ("/update.cu")
	public String update(CustomerVO vo) {
		// 화면에서 입력한 수정 정보를 DB에 저장한 후 상세화면(detail)으로 연결
		service.customer_update(vo);
		return "redirect:detail.cu?id=" + vo.getId();
	}
	
	// id에 해당하는 고객 정보 수정 화면 요청
	@RequestMapping ("/modify.cu")
	public String modify(int id, Model model) {
		// DB에서 id에 해당하는 고객의 정보를 조회해와 수정 화면에 전달
		model.addAttribute("vo", service.customer_detail(id) );
		return "customer/modify";
	}
	
	
	// 신규 고객 정보 DB에 저장 요청
	@RequestMapping ("/insert.cu")
	public String insert(CustomerVO vo) {
		// 화면에서 입력한 정보를 DB에 저장 후 목록화면으로 연결
		service.customer_insert(vo);
		
		return "redirect:list.cu";	// 등록 이후 전체 회원 조회를 통해 갱신 필요
	}
		
	// 신규 고객 정보 입력 화면 요청
	@RequestMapping ("/new.cu")
	public String new_customer() {
		return "customer/new";
	}
	
	// 고객의 상세 정보 조회 요청
	@RequestMapping ("/detail.cu")
	public String detail(int id, Model model) {
		// 선택한 고객 정보를 DB에서 조회
		
//		CustomerVO vo = service.customer_detail(id);
//		model.addAttribute("vo", vo);
		
		model.addAttribute("vo", service.customer_detail(id) );
		
		return "customer/detail";
	}
	
	
	
	// 고객 관리 목록 요청
	@RequestMapping ("/list.cu")
	public String list(HttpSession session, Model model ) {
		session.setAttribute("category", "cu");
		
		List<CustomerVO> list = service.customer_list();
		
		// DB에서 목록을 잘 가져왔는지 vo의 이름(name)을 Console(Syso) 에 출력시오.
		/* for ( ②배열타입 반복변수명 : ①배열 또는 리스트명 ) {
		 * 		③ 실행문;
		 * }  향상된 for문은 자료구조(컬렉션) 형태의 데이터를 추출시 사용 */
		
		for (CustomerVO vo : list) {
			System.out.println(vo.getName());
		}		
		
		model.addAttribute("list", list);
		// Model타입변수.addAttribute("속성명", 저장할 데이터);		
		
		return "customer/list";		// views/customer/list.jsp 파일을 호출
	}
	
}











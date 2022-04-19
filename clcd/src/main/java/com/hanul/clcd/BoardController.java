package com.hanul.clcd;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import board.BoardPage;
import board.BoardServiceImpl;
import board.BoardVO;
import common.CommonService;
import member.MemberVO;

@Controller
public class BoardController {

	@Autowired private BoardServiceImpl service;
	@Autowired private BoardPage page;
	@Autowired private CommonService common;
	
	// 방명록 신규 저장 처리 요청
	@RequestMapping ("/insert.bo")
	public String insert(BoardVO vo, MultipartFile file, HttpSession session) {
		
		if ( ! file.isEmpty() ) { // 파일 정보가 있다면
			vo.setFilename( file.getOriginalFilename());
			vo.setFilepath( common.fileUpload("board", file, session));
		}
		
		vo.setWriter( ((MemberVO) session.getAttribute("loginInfo")).getId() );
		
//		MemberVO member = (MemberVO) session.getAttribute("loginInfo");
//		vo.setWriter( member.getId() );
		
		// 화면에서 입력한 정보를 DB에 신규저장한 후 목록화면 연결
		service.board_insert(vo);
		return "redirect:list.bo";
	}
	
	// 방명록 신규 글 작성 화면 요청
	@RequestMapping ("/new.bo")
	public String board() {
		return "board/new";
	}
	
	
	// 방명록 목록화면 요청
	@RequestMapping ("/list.bo")
	public String list(HttpSession session, Model model,
			@RequestParam(defaultValue = "1") int curPage,
			@RequestParam(defaultValue = "10") int pageList,
			String search, String keyword) {
		session.setAttribute("category", "bo");
		
		page.setCurPage(curPage);	// 현재 페이지값
		page.setSearch(search);		// 검색 조건
		page.setKeyword(keyword);	// 검색어
		page.setPageList(pageList);	// 페이지당 보여질 글 목록 수
		
		model.addAttribute("page", service.board_list(page));
		return "board/list";
	}
	
}











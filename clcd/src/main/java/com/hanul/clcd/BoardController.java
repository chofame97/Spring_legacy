package com.hanul.clcd;

import java.io.File;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import board.BoardCommentVO;
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
	
	// 방명록 글에 대한 댓글 목록 조회 요청
	@RequestMapping ("/board/comment/list/{pid}")
	public String comment_list(@PathVariable int pid, Model model) {
		// 해당 글에 대한 댓글들을 DB에서 조회해 옴.
		model.addAttribute("list", service.board_comment_list(pid));
		
		return "board/comment/comment_list";
	}
	
	// 방명록 글에 대한 댓글저장처리 요청
	@ResponseBody
	@RequestMapping ("/board/comment/regist")
	public boolean comment_regist(BoardCommentVO vo, HttpSession session) {
		// 작성자의 경우 member의 id 값을 담아야 하므로 로그인 정보 확인
		MemberVO member = (MemberVO) session.getAttribute("loginInfo");
		vo.setWriter(member.getId());
		
		// 화면에서 입력한 댓글정보를 DB에 저장한 후 저장 여부를 확인
		return service.board_comment_insert(vo) == 1 ? true : false;
		// 반환결과가 1 이면 True 아니면 False 값을 반환...
	}
	
	
	
	
	// 방명록 글 수정 저장처리 요청 
	@RequestMapping ("/update.bo")
	public String update(BoardVO vo, HttpSession session, Model model,
			MultipartFile file, String attach) {
		// 원 글에 첨부 파일이 있었는지...
		BoardVO board = service.board_detail(vo.getId());
		String uuid = session.getServletContext().getRealPath("resources") + "/" + board.getFilepath();
		
		// 파일을 첨부하지 않은 경우
		if ( file.isEmpty() ) {
			// 원래부터 첨부된 파일이 없는 경우
			// 원래 첨부된 파일이 있었는데 삭제한 경우
			if ( attach.isEmpty() ) {
				// 원래 첨부되어 있는 파일이 있다면 서버의 물리적 영역에서 삭제
				if ( board.getFilename() != null ) {
					File f = new File(uuid);
					if (f.exists()) f.delete();	// 파일이 존재하면 파일을 삭제
				}
			} else {
				// 원래 첨부된 파일을 그대로 사용하는 경우
				vo.setFilename( board.getFilename() );
				vo.setFilepath( board.getFilepath() );
			}
		} else {	// 파일을 첨부한 경우
			vo.setFilename( file.getOriginalFilename() );
			vo.setFilepath( common.fileUpload("board", file, session) );
			
			// 원래 첨부되어 있는 파일이 있다면 서버의 물리적 영역에서 삭제
			if ( board.getFilename() != null) {
				File f = new File(uuid);
				if (f.exists())  f.delete();
			}
		}
		
		// 화면에서 수정한 정보들을 DB에 수정 저장 후 상세화면 연결
		service.board_update(vo);
		
		model.addAttribute("url", "detail.bo");
		model.addAttribute("id", vo.getId());
		
		return "board/redirect";
//		return "redirect:detail.bo?id=" + vo.getId();
	}
	
	// 방명록 글 수정 화면 요청
	@RequestMapping ("/modify.bo")
	public String modify(int id, Model model) {
		// id에 해당하는 방명록 글을 DB에서 조회해와 수정화면에 출력
		model.addAttribute("vo", service.board_detail(id));	
		return "board/modify";
	}
	
	// 방명록 글 삭제처리 요청
	@RequestMapping ("/delete.bo")
	public String delete(int id, HttpSession session, Model model) {
		// 첨부 파일이 있는 글에 대해서는 해당 파일을 물리적 영역에서 삭제
		BoardVO vo = service.board_detail(id);
		if ( vo.getFilename() != null  ) {
			File file = new File(session.getServletContext().getRealPath("resources") 
							+ "/" + vo.getFilename());
			if (file.exists() ) file.delete();			
		}
		
		// id에 해당하는 방명록 글을 DB에서 삭제한 후 목록화면으로 연결
		service.board_delete(id);
	// 	return "redirect:list.bo";
		
		model.addAttribute("url", "list.bo");
		model.addAttribute("page", page);	
		
		return "board/redirect";
		
	}
	
	
	// 방명록 첨부파일 다운로드 요청
	@RequestMapping ("/download.bo")
	public void download(int id, HttpSession session, HttpServletResponse response) {
		// 해당 글의 첨부파일 정보를 DB에서 조회해와
		// 해당 파일을 서버로부터 다운로드 함.
		BoardVO vo = service.board_detail(id);
		common.fileDownload(vo.getFilename(), vo.getFilepath(), session, response);
	}
	
	// 방명록 상세화면 요청
	@RequestMapping ("/detail.bo")
	public String detail(int id, Model model) {
		// 상세화면 조회 전 조회수 증가
		service.board_read(id);
		
		// 해당 방명록 글을 DB에서 조회해와 상세화면에 출력
		model.addAttribute("vo", service.board_detail(id));
		model.addAttribute("crlf", "\r\n");
		model.addAttribute("page", page);	// 목록으로 가는데 사용할 정보
		
		return "board/detail";
	}
	
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
			@RequestParam(defaultValue = "list") String viewType,
			String search, String keyword) {
		session.setAttribute("category", "bo");
		
		page.setCurPage(curPage);	// 현재 페이지값
		page.setSearch(search);		// 검색 조건
		page.setKeyword(keyword);	// 검색어
		page.setPageList(pageList);	// 페이지당 보여질 글 목록 수
		page.setViewType(viewType);	// 게시판 형태
		
		model.addAttribute("page", service.board_list(page));
		return "board/list";
	}
	
}











package com.project.erjr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import communitymobile.CommunityCommentDTO;
import communitymobile.CommunityDAO;
import communitymobile.CommunityVO;

@Controller
public class CommunityController {
	Gson gson = new Gson();
	@Autowired CommunityDAO dao;
	@Autowired SqlSession sql;
	
	//커뮤니티 화면을 요청
	@RequestMapping("/cmnty")
	public String cmnty(HttpSession session) {
		session.setAttribute("category", "cmnty");
		
		return "community/cmnty";
	}
	
	//안드로이드 커뮤니티 리스트
	@ResponseBody
	@RequestMapping(value="/mcmnty", produces = "application/json;charset=UTF-8")
	public String m_cmnty() {
		List<CommunityVO> list = dao.list();
//		for(CommunityVO cmntVO : list) {
//			System.out.println(cmntVO.getBoard_title()+cmntVO.getBoard_contents());
//		}
//		System.out.println(list);
		return gson.toJson(list);
	}
	
	@ResponseBody
	@RequestMapping(value="/mcmnty.selectlist", produces = "application/json;charset=UTF-8")
	public String m_cmnty_select(HttpServletRequest req) {
		CommunityVO vo = gson.fromJson(req.getParameter("vo"), CommunityVO.class);
		List<CommunityVO> list = sql.selectList("community.mapper.selectlist", vo);

		return gson.toJson(list);
	}
	
	@ResponseBody
	@RequestMapping(value="/mcmnty.detail", produces = "application/json;charset=UTF-8")
	public String m_cmnty_detail(HttpServletRequest req) {
		CommunityVO vo = gson.fromJson(req.getParameter("vo"), CommunityVO.class);
		
		vo = sql.selectOne("community.mapper.detail", vo);
		return gson.toJson(vo);
	}
	
	//안드로이드 커뮤니티 작성
	@ResponseBody
	@RequestMapping(value="/mcmnty.insert", produces = "application/json;charset=UTF-8")
	public boolean m_cmnty_insert(HttpServletRequest req) {
		CommunityVO vo = gson.fromJson(req.getParameter("vo"), CommunityVO.class);
		
		boolean result = sql.insert("community.mapper.insert",vo) == 0 ? false : true;
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/mcmnty.update", produces = "application/json;charset=UTF-8")
	public boolean m_cmnty_update(HttpServletRequest req) {
		CommunityVO vo = gson.fromJson(req.getParameter("vo"), CommunityVO.class);
		System.out.println(vo);
		boolean result = sql.update("community.mapper.update",vo) == 0 ? false : true;
		System.out.println(result);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/mcmnty.delete", produces = "application/json;charset=UTF-8")
	public void m_cmnty_delete(HttpServletRequest req) {
		CommunityVO vo = gson.fromJson(req.getParameter("vo"), CommunityVO.class);
		
		sql.delete("community.mapper.delete",vo);
	}
	
	@ResponseBody
	@RequestMapping(value="/mcmnty.comment", produces = "application/json;charset=UTF-8")
	public String m_cmnty_comment(HttpServletRequest req){
		CommunityVO vo = gson.fromJson(req.getParameter("vo"), CommunityVO.class);
		System.out.println(vo);
		List<CommunityCommentDTO> list = sql.selectList("community.mapper.comment",vo);
		System.out.println(list);
		return gson.toJson(list);
	}
	
	@ResponseBody
	@RequestMapping(value="/mcmnty.comment.insert", produces = "application/json;charset=UTF-8")
	public boolean m_cmnty_comment_insert(HttpServletRequest req) {
		CommunityCommentDTO dto = gson.fromJson(req.getParameter("dto"), CommunityCommentDTO.class);
		
		boolean result = sql.insert("community.mapper.comment_insert", dto) == 0 ? false : true;
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/mcmnty.comment.delete", produces = "application/json;charset=UTF-8")
	public void m_cmnty_comment_delete(HttpServletRequest req) {
		CommunityCommentDTO dto = gson.fromJson(req.getParameter("dto"), CommunityCommentDTO.class);
		
		sql.delete("community.mapper.comment_delete",dto);
	}
	
	@ResponseBody
	@RequestMapping(value="/mcmnty.comment.update", produces = "application/json;charset=UTF-8")
	public boolean m_cmnty_comment_update(HttpServletRequest req) {
		CommunityCommentDTO dto = gson.fromJson(req.getParameter("dto"), CommunityCommentDTO.class);
		
		boolean result = sql.update("community.mapper.comment_update",dto) == 0 ? false : true;
		System.out.println(result);
		return result;
	}
}

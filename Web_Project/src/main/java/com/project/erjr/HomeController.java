package com.project.erjr;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import list.GuinDTO;
import list.MemberDAO;


@Controller
public class HomeController {
	
	@Autowired private MemberDAO dao;
	@Autowired @Qualifier("bteam") SqlSession sql;
	
	Gson gson = new Gson();
	
			
	// 메인 페이지
	@RequestMapping("/")
	public String home() {
		
		return "main";
	}
	// 알알이 구하기 이동
	@RequestMapping("/searchArAr")
	public String searchArAr() {
		
		return "menu2/searchArAr";
	}
	// 고객센터 이동
	@RequestMapping("/serviceCenter")
	public String serviceCenter() {
		
		return "menu2/serviceCenter";
	}
	// 고객센터 이동
	@RequestMapping("/Community")
	public String community() {
		
		return "menu2/Community";
	}
	// 로그인
	@RequestMapping("/login")
	public String login() {
		
		return "goLogin";
	}
	
	
		
	
	// 구인글 목록(메인, 구인페이지)
	@ResponseBody
	@RequestMapping(value ="/giuplist", produces = "application/json;charset=UTF-8")
	public String giuplist() {
		List<GuinDTO> df = sql.selectList("test.mapper.test");		
		
		return gson.toJson(df);
	}
	
	// 구인게시글 상세 페이지
	@ResponseBody
	@RequestMapping(value ="/giupClick", produces = "application/json;charset=UTF-8")
	public String giupClick(HttpServletRequest req) {
		
		//dto.setMember_id(req.getParameter("id"));
		//dto.setGiup_title(req.getParameter("postTitle"));
		
			System.out.println(req.getParameter("id"));
		
		return "";
	}
		
		
		
		
		
	
}
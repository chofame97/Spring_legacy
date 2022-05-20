package com.project.erjr;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
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

import Member.EmailNumberVO;
import Member.GiupNumberDTO;
import Member.IdDTO;
import Member.MemberDTO;
import list.MemberDAO;

@Controller
public class MemberController {
	
	@Autowired @Qualifier("bteam") SqlSession sql;
	
	// 이메일 인증
	@Autowired
	private JavaMailSender mailSender;
	
	Gson gson = new Gson();
	
	
	// 이메일 인증
	@ResponseBody
	@RequestMapping(value ="/emailCheck", produces = "application/json;charset=UTF-8")
	public String emailCheck(HttpServletRequest req) {
			JSONObject json = new JSONObject(req.getParameter("email"));
			String email = json.getString("member_email"); 
			
			// 인증번호 난수 생성 ,범위 (111,111 ~ 999,999)
			Random random = new Random();
			int checkNum = random.nextInt(888888) + 111111;
			
			System.out.println("이메일 : "+email);
			System.out.println("인증번호 : "+checkNum);
			
			String setForm = "hanulbteam@gmail.com";
			String toMail = email;
			String title = "이알저알 회원가입 인증 이메일 입니다";
			String content = "<br>인증 번호는 " + checkNum + " 입니다<br>";
			
			try {
	            MimeMessage message = mailSender.createMimeMessage();
	            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
	            helper.setSubject(title);
	            helper.setText(content,true);
	            helper.setFrom(setForm);
	            helper.setTo(toMail);		      
	            mailSender.send(message);		            
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
			EmailNumberVO vo = new EmailNumberVO(checkNum);
			
		return gson.toJson(vo);
	}
			

	
	// 사업자 등록번호 조회
	@ResponseBody
	@RequestMapping(value ="/numbertest", produces = "application/json;charset=UTF-8")
	public String numberTest(HttpServletRequest req) {
		
		JSONObject json = new JSONObject(req.getParameter("number"));
		
		String nu = json.getString("b_no");
		
		System.out.println(nu);
		System.out.println("사업자 등록번호 : "+req.getParameter("number"));
		GiupNumberDTO dto = null;
		URL url;
		try {
			url = new URL(
					"https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey=gS7w9BBE3He%2FFTkjgInbf8iJxTmmAPaAYpTeopmJeJ6TM%2FXfi4wbAdmBZWUCcqe3l6dNktJ%2BNoClU2F5Vpr9Qg%3D%3D");
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("POST");

			httpConn.setRequestProperty("accept", "application/json");
			httpConn.setRequestProperty("Authorization",
					"gS7w9BBE3He/FTkjgInbf8iJxTmmAPaAYpTeopmJeJ6TM/Xfi4wbAdmBZWUCcqe3l6dNktJ+NoClU2F5Vpr9Qg==");
			httpConn.setRequestProperty("Content-Type", "application/json");

			httpConn.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());

			writer.write("{  \"b_no\": [    \"" + nu + "\"  ]}");
			writer.flush();
			writer.close();
			httpConn.getOutputStream().close();

			InputStream responseStream = httpConn.getResponseCode() / 100 == 2 ? httpConn.getInputStream()
					: httpConn.getErrorStream();
			Scanner s = new Scanner(responseStream).useDelimiter("\\A");
			String response = s.hasNext() ? s.next() : "";
			System.out.println(response);
			// 받아온 json 파일 파싱
			JSONObject jsonObject = new JSONObject(response);
			JSONArray datas = jsonObject.getJSONArray("data");
			String value = "";
			for (int i = 0; i < datas.length(); i++) {
				jsonObject = datas.getJSONObject(i);
				value = jsonObject.getString("b_stt_cd");
			}
			dto = new GiupNumberDTO(value);
			System.out.println(gson.toJson(dto));
			return gson.toJson(dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gson.toJson(dto);
	}
	
	// 아이디 중복검사
	@ResponseBody
	@RequestMapping(value ="/idDuplicate", produces = "application/json;charset=UTF-8")
	public String idTest(HttpServletRequest req) {
		JSONObject json = new JSONObject(req.getParameter("id"));	
		String id = json.getString("id");
		IdDTO dto = new IdDTO(id);
		int count = sql.selectOne("test.mapper.idlist",dto);
		IdDTO countt = new IdDTO(""+count);
		return gson.toJson(countt);
	}
	
	// 사업자번호 중복검사
	@ResponseBody
	@RequestMapping(value ="/idDuplicate", produces = "application/json;charset=UTF-8")
	public String giupNumberTest(HttpServletRequest req) {
		JSONObject json = new JSONObject(req.getParameter("b_no"));	
		String id = json.getString("id");
		IdDTO dto = new IdDTO(id);
		int count = sql.selectOne("test.mapper.idlist",dto);
		IdDTO countt = new IdDTO(""+count);
		return gson.toJson(countt);
	}

	
	
}

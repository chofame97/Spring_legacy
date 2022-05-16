package com.project.erjr;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;


@Controller
public class HomeController {
	
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
	
	// 사업자 등록번호 조회
		@RequestMapping("/numbertest")
		public String numberTest(@RequestParam String number) {
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

				writer.write("{  \"b_no\": [    \"" + number + "\"  ]}");
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

				for (int i = 0; i < datas.length(); i++) {
					jsonObject = datas.getJSONObject(i);
					String value = jsonObject.getString("b_stt_cd");

					System.out.println(value);
					return value;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "";
		}
		
		//@Autowired @Qualifier("bteam") private SqlSession sql;
		@ResponseBody
		@RequestMapping(value ="/giuplist", produces = "application/json;charset=UTF-8")
		public void giuplist() {
			//System.out.println(new GiupDAO().select());
			
		}
		
	
}
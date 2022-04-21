package com.hanul.clcd;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		session.removeAttribute("category");		
		return "home";
	}
	
	// error 처리 요청
	@RequestMapping ("/error")
	public String error( HttpServletRequest request, Model model ) {
		
		Throwable error = (Throwable) request.getAttribute("javax.servlet.error.exception");
		StringBuffer msg = new StringBuffer();
		while ( error != null ) {
			msg.append("<p>").append(error.getMessage()).append("</p>");
			error = error.getCause();   // exception 이 발생한 근본적인 원인을 리턴한다.
		}
		
		model.addAttribute("msg", msg.toString());
		
		int code = (int) request.getAttribute("javax.servlet.error.status_code");
		
		return "error/" + ( code == 404 ? 404 : "common");
		// error 코드가 404 이면 404.jsp로... 아니면 common.jsp 페이지로 리턴
	}
	
	
	
}








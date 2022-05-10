package org.zrock.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExeception {
	
	@ExceptionHandler(Exception.class)
	public String except() {
		
		return "exceptionPage";
	}
}

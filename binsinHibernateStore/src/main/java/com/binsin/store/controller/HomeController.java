package com.binsin.store.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	// com.binsin 에 있던 로그 내용을 상속 받는다. -> daily, minutes, console 모두 상속 받은 상태
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class); // com.binsin.controller.HomeController
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Locale locale, Model model) {
		
		// level value="DEBUG" 이므로 debug 레벨보다 높은 것들만 출력된다.
		// logger.trace("trace level: Welcome home! The client locale is {}", locale);
		// logger.debug("debug level: Welcome home! The client locale is {}", locale);
		logger.info("info level: Welcome home! The client locale is {}", locale);
		// logger.warn("warn level: Welcome home! The client locale is {}", locale);
		// logger.error("error level: Welcome home! The client locale is {}", locale);
		
		String url = request.getRequestURL().toString();
		String clientIPaddress = request.getRemoteAddr();
		logger.info("Request URL: " + url);
		logger.info("Client IP: " + clientIPaddress);
		
		return "home";
	}
	
}
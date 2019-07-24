package com.binsin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	//tatic Logger logger = LoggerFactory.getLogger(HomeController.class);

	// @RequestMapping(value="/", method = RequestMethod.GET).
	@GetMapping("/")
	public String home(Model model) {

		//logger.debug("Calling home( )");

		model.addAttribute("message", "hello world");
		return "index";

	}
}
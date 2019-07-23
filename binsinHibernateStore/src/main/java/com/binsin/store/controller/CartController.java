package com.binsin.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.binsin.store.model.User;
import com.binsin.store.service.UserService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String getCart(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		User user = userService.getUserByUsername(username);
		int cartId = user.getCart().getId();
		
		model.addAttribute("cartId", cartId);
		
		return "cart";
	}
}

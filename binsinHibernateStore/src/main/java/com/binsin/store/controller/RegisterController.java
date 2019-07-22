package com.binsin.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.binsin.store.model.ShippingAddress;
import com.binsin.store.model.User;
import com.binsin.store.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/register")
	public String registerUser(Model model) {
		
		User user = new User();
		ShippingAddress shippingAddress = new ShippingAddress();
		
		user.setShippingAddress(shippingAddress);
		
		model.addAttribute("user", user);
		
		return "registerUser";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerUserPost(@Valid User user, BindingResult result, Model model) {
		
		if(result.hasErrors())
			return "registerUser";
		
		List<User> userList = userService.getAllUsers();
		
		for(User u : userList) {
			if(user.getUsername().equals(u.getUsername())) {
				model.addAttribute("usernameMsg", "username already exist");
				return "registerUser";
			}
		}
		
		user.setEnabled(true);
		// user.setPassword("{bcrypt}" + user.getPassword());
		
		if(user.getUsername().equals("admin"))
			user.setAuthority("ROLE_ADMIN");
		else
			user.setAuthority("ROLE_USER");
		
		userService.addUser(user);
		
		return "registerUserSuccess";
	}
	
}

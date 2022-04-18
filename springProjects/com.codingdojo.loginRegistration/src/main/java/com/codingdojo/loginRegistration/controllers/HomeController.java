package com.codingdojo.loginRegistration.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.codingdojo.loginRegistration.models.LoginUser;
import com.codingdojo.loginRegistration.models.Users;
import com.codingdojo.loginRegistration.services.UserService;

@Controller
public class HomeController {
	private final UserService userSer;
	public HomeController(UserService userSer) {
		this.userSer = userSer;
	}
	
	// ================ GENERAL ================
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("newUser") Users users, @ModelAttribute("newLogin") LoginUser loginUser) {
		return "index.jsp";
	}
}

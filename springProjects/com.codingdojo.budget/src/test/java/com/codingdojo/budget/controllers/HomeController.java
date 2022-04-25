package com.codingdojo.budget.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.budget.models.LoginUser;
import com.codingdojo.budget.models.User;
import com.codingdojo.budget.services.UserService;



@Controller
public class HomeController {
private final UserService userSer;
	
	public HomeController(UserService userSer) {
		super();
		this.userSer = userSer;
	}
	
	// ================ GENERAL ================
	
	
	
}

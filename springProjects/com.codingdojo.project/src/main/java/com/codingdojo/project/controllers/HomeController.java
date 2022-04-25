package com.codingdojo.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index(Model model) {
		return "index.jsp";
	}
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard.jsp";
	}
	
	@GetMapping("/settings")
	public String settings() {
		return "settings.jsp";
	}
	
	@GetMapping("/edit/smuget")
	public String editSmuget() {
		return "editSmuget.jsp";
	}
	
}

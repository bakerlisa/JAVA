package com.codingdojo.fullCrud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	//route dashboard - all candies
	@GetMapping("/dashboard")
	public String index(Model model) {
		return "index.jsp";
	}
	
	// New Candy
	@GetMapping("/newCandy")
	public String newCandyForm(Model model) {
		return "newCandy.jsp";
	}
	
	//One Candy
	@GetMapping("/oneCandy")
	public String oneCandy(Model model) {
		return "oneCandy.jsp";
	}
	
	// Update Candy
	@GetMapping("/updateCandy")
	public String updateCandyForm(Model model) {
		return "updateCandy.jsp";
	}
	
	// Delete
	@GetMapping("/delete/{id}")
	public String delete(Model model) {
		return "redirect/:dashboard";
	}
}

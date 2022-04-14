package com.codingdojo.fullCrud.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.fullCrud.models.Candy;
import com.codingdojo.fullCrud.services.CandyService;

@Controller
public class HomeController {
	
	@Autowired
	CandyService candyService;
	
	//route dashboard - all candies
	@GetMapping("/dashboard")
	public String index(Model model) {
		return "index.jsp";
	}
	
	// New Candy
	@GetMapping("/newCandy")
	public String newCandyForm(Model model, @ModelAttribute("candy") Candy candy ) {
		return "newCandy.jsp";
	}
	
	@PostMapping("/api/create/candy")
	public String createNewCandy(Model model, @Valid @ModelAttribute("candy") Candy candy, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}else {
			candyService.createCandy(candy);
			return "redirect/:dashboard";
		}
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

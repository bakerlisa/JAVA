package com.codingdojo.PlantKeeper.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
	
	// ========================= GENERAL ========================= 
	@GetMapping("/")
	public String index(Model model) {
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dash(Model model) {
		return "dashboard.jsp";
	}
	
	// ========================= LOGIN / REG ========================= 
	
	
	
	// ========================= PLANTS =========================
	@GetMapping("/edit/plant")
	public String editPlant(Model model) {
		return "editPlant.jsp";
	}
	
	@GetMapping("/add/plant")
	public String addPlant(Model model) {
		return "addPlant.jsp";
	}
	
	@GetMapping("/plant/{id}")
	public String plant(Model model, @PathVariable("id") Long id ) {
		return "plant.jsp";
	}
	
}

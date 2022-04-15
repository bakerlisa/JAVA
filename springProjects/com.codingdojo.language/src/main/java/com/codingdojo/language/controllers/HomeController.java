package com.codingdojo.language.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.language.models.Language;
import com.codingdojo.language.services.LanguageService;




@Controller
public class HomeController {
	
	@Autowired
	LanguageService langSer;
	
	@GetMapping("/languages")
	public String index(@ModelAttribute("language") Language language) {
		return "index.jsp";
	}
	
	@PostMapping("/api/create")
	public String createLangauge(Model model,@Valid @ModelAttribute("language") Language language, BindingResult result) {
		return "index.jsp";
	}

}

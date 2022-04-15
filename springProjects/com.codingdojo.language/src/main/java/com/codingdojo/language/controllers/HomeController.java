package com.codingdojo.language.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.language.models.Language;
import com.codingdojo.language.services.LanguageService;




@Controller
public class HomeController {
	
	@Autowired
	LanguageService langSer;
	
	// dashboard - lists all 
	@GetMapping("/languages")
	public String index(Model model, @ModelAttribute("language") Language language) {
		List<Language> languages = langSer.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	// form path to create a new langauge
	@PostMapping("/api/create")
	public String createLangauge(Model model,@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";			
		}else {
			langSer.createLanguage(language);
			return "index.jsp";	
		}
	}
	
	// path to show one langauge
	@GetMapping("/langauge/{id}")
	public String showLanguage(Model model, @PathVariable("id") Long id ) {
		Language language = langSer.findLanguage(id);
		model.addAttribute("language", language);
		return "language.jsp";
	}
	
	// path to edit langauge
	@GetMapping("/langauge/{id}/edit")
	public String editLanguage(Model model, @PathVariable("id") Long id) {
		Language language = langSer.findLanguage(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	
	// form route to update
	@PostMapping("/api/update")
	public String updateLangauge(Model model,@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";			
		}else {
			langSer.updateNewLanguage(language);
			return "redirect:/languages";
		}
	}
	
	//delete route
	@DeleteMapping("/langauge/{id}/delete")
	public String destroy(@PathVariable("id") Long id){
		langSer.deleteLang(id);
		return "redirect:/languages";
	}
	

}

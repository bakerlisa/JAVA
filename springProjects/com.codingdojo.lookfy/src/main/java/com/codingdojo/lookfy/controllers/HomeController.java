package com.codingdojo.lookfy.controllers;

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

import com.codingdojo.lookfy.models.Lookify;
import com.codingdojo.lookfy.services.LookifyService;

@Controller
public class HomeController {
	
	@Autowired
	LookifyService lookifyService;
	
	
	// PAGE - home
	@GetMapping("/")
	public String index(Model model) {
		return "lookify.jsp";
	}
	
	// PAGE - dash 
	@GetMapping("/dashboard")
	public String dash(Model model) {
		List<Lookify> lookify = lookifyService.allLookys();
		model.addAttribute("looky", lookify);
		
		return "dashboard.jsp";
	}

	// PAGE - add song
	@GetMapping("/songs/add")
	public String add(Model model, @ModelAttribute("lookify") Lookify lookify ) {
		return "add.jsp";
	}
	
	// DATABASE - add song
	@PostMapping("/api/create/song")
	public String createNewCandy(Model model, @Valid @ModelAttribute("lookify") Lookify lookify, BindingResult result) {
		System.out.println(lookify);
		if(result.hasErrors()) {
			return "add.jsp";
		}else {
			lookifyService.createLooky(lookify);
			return "redirect:/dashboard";
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteSong(@PathVariable("id")Long id) {
		lookifyService.deleteSong(id);
        return "redirect:/dashboard";
	}
	
	@GetMapping("/search")
	public String search() {
		return "search.jsp";
	}
	
}

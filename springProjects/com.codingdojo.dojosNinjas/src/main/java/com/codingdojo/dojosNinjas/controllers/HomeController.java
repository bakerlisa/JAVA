package com.codingdojo.dojosNinjas.controllers;

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

import com.codingdojo.dojosNinjas.models.Dojo;
import com.codingdojo.dojosNinjas.models.Ninja;
import com.codingdojo.dojosNinjas.services.DojoService;
import com.codingdojo.dojosNinjas.services.NinjaService;

@Controller
public class HomeController {
	
	@Autowired
	private final DojoService dojoServ;
	private final NinjaService ninjaServ;
	
	public HomeController(DojoService dojoServ,NinjaService ninjaServ) {
		super();
		this.dojoServ = dojoServ;
		this.ninjaServ = ninjaServ;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		List<Dojo> dojos = dojoServ.allDojos();
		model.addAttribute("dojos", dojos);
		return "index.jsp";
	}
	
	@GetMapping("/add/dojo")
	public String addDojo(Model model, @ModelAttribute("dojo") Dojo dojo) {
		return "addDojo.jsp";
	}
	
	@PostMapping("/api/add/dojo")
	public String addFormDojo(Model model, @Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "addDojo.jsp";
		}else {
			dojoServ.createDojo(dojo);
			return "redirect:/";
		}
	}
	@GetMapping("/dojo/{id}")
	public String singleDojo(Model model, @PathVariable("id")Long id) {
		Dojo dojo = dojoServ.singleDojoInfo(id);
		model.addAttribute("dojo",dojo);
		return "dojo.jsp";
	}
	
	@GetMapping("/edit/dojo/{id}")
	public String editDojo(Model model, @PathVariable("id")Long id) {
		List<Ninja> ninjas = dojoServ.allDojoNinjas(id);
		model.addAttribute("ninjas", ninjas);
		return "editDojo.jsp";
	}
	
	@DeleteMapping("/delete/dojo/{id}")
	public String destroyDojo( @PathVariable("id") Long id) {
		dojoServ.deleteDojo(id);
		return "redirect:/";
	}
	
	
	// ================ NINJAS ================
	@GetMapping("/ninjas")
	public String allNinjas(Model model) {
		List<Ninja> ninjas = ninjaServ.allNinjas();
		model.addAttribute("ninjas", ninjas);
		return "ninjas.jsp";
	}
	
	@GetMapping("/add/ninja")
	public String addNinja(Model model, @ModelAttribute("ninja") Ninja ninj) {
		List<Dojo> dojos = dojoServ.allDojos();
		model.addAttribute("dojos", dojos);
		return "addNinja.jsp";
	}
	
	@PostMapping("/api/add/ninja")
	public String addFormNinja(Model model, @Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			List<Dojo> dojos = dojoServ.allDojos();
			model.addAttribute("dojos", dojos);
			return "addNinja.jsp";
		}else {
			ninjaServ.createNinja(ninja);
			return "redirect:/";
		}
	}
	
	@GetMapping("/edit/ninja/{id}")
	public String editNinja(Model model, @PathVariable("id")Long id) {
		return "editNinja.jsp";
	}
	
	@DeleteMapping("/delete/ninja/{id}")
	public String destroyNinja( @PathVariable("id") Long id) {
		ninjaServ.deleteNinja(id);
		return "redirect:/ninjas";
	}
}

package com.codingdojo.relationships.controllers;

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

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.LicenseService;
import com.codingdojo.relationships.services.PersonService;

@Controller
public class HomeController {
	
	@Autowired
	private final PersonService personSer;
	private final LicenseService licenseSer;
	
	public HomeController(PersonService personSer,LicenseService licenseSer) {
		super();
		this.personSer = personSer;
		this.licenseSer = licenseSer;
	}
	
	// Dash
	@GetMapping("/")
	public String index(Model model) {
		List<Person> people = personSer.allPeople();
		model.addAttribute("people",people);
		return "index.jsp";
	}
	
	// PAGE - single person
	@GetMapping("/people/{id}")
	public String onePerson(Model model,@PathVariable("id") Long id) {
		Person person = personSer.findPerson(id);
		model.addAttribute("person",person);
		return "person.jsp";
	}
	
	// PAGE - add person
	@GetMapping("/add/person")
	public String addPerson(Model model, @ModelAttribute("person") Person person) {
		return "addPerson.jsp";
	}
	
	// ADDING - new song
	@PostMapping("/api/add/person")
	public String addPersonForm(Model model, @Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "addPerson.jsp";
		}else {
			personSer.createPerson(person);
			return "redirect:/";
		}
	}
	
	// PAGE - edit song
	@GetMapping("/edit/{id}")
	public String editPerson(Model model, @PathVariable("id") Long id) {
		Person person = personSer.findPerson(id);
		model.addAttribute("person", person);
		return "editPerson.jsp";
	}
	
	@DeleteMapping("/delete/{id}")
	public String destroyPerson( @PathVariable("id") Long id) {
		personSer.deletePerson(id);
		return "redirect:/";
	}
	
	// ================ LICENSE ================
	@GetMapping("/licenses")
	public String allLicenses(Model model) {
		List<License> license = licenseSer.allLicenses();
			
		model.addAttribute("license", license);
			
		return "licenses.jsp";
	}
		
	// ADDING - new song
	@PostMapping("/api/add/license")
	public String addLicenseForm(Model model, @Valid @ModelAttribute("license") License license, BindingResult result) {
		System.out.println(license);
		if(result.hasErrors()) {
			model.addAttribute("people", personSer.allPeople());
			return "addLicense.jsp";
		}else {
			licenseSer.createLicense(license);
			return "redirect:/";
		}
	}
	
	// PAGE - add license
	@GetMapping("/add/license")
	public String addLicense(Model model, @ModelAttribute("license") License license) {
		List<Person> people = personSer.allPeople();
		model.addAttribute("people", people);
		return "addLicense.jsp";
	}
	
	@DeleteMapping("/delete/license/{id}")
	public String destroyLicense( @PathVariable("id") Long id) {
		licenseSer.deleteLicense(id);
		return "redirect:/";

	}
		
			
}

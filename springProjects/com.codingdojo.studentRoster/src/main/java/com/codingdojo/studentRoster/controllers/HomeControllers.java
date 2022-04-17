package com.codingdojo.studentRoster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.studentRoster.models.Dorm;
import com.codingdojo.studentRoster.models.Student;
import com.codingdojo.studentRoster.services.DormService;
import com.codingdojo.studentRoster.services.StudentService;

@Controller
public class HomeControllers {
	
	@Autowired
	private final DormService dormServ;
	private final StudentService studentServ;
	
	public HomeControllers(DormService dormServ,StudentService studentServ) {
		super();
		this.dormServ = dormServ;
		this.studentServ = studentServ;
	}
	
	// ========== GENERAL ==========
	@GetMapping("/")
	public String index(Model model) {
		return "index.jsp";
	}
	@GetMapping("/dashboard")
	public String dash(Model model) {
		return "dashboard.jsp";
	}
	
	// ========== DORM ==========
	@GetMapping("/add/dorm")
	public String addDorm(Model model, @ModelAttribute("dorm") Dorm dorm) {
		return "addDorm.jsp";
	}
	
	@PostMapping("/api/add/dorm")
	public String addDormForm(Model model, @Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
		if(result.hasErrors()) {
			return "addDorm.jsp";
		}else {
			dormServ.addNewDorm(dorm);
			return "redirect:/dorms";
		}
	}
	
	@GetMapping("/dorms")
	public String allDorms(Model model) {
		List<Dorm> dorms = dormServ.findAllDorms();
		model.addAttribute("dorms",dorms);
		return "dorms.jsp";
	}
	
	// ========== STUDENT ==========
	@GetMapping("/add/student")
	public String addStudent(Model model) {
		return "addStudent.jsp";
	}
	
	@GetMapping("/students")
	public String allStudents(Model model) {
		List<Student> students = studentServ.allStudents();
		model.addAttribute("students",students);
		return "students.jsp";
	}
	
}

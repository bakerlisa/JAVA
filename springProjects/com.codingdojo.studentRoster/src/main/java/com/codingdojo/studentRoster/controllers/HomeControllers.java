package com.codingdojo.studentRoster.controllers;

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
	
	@GetMapping("/edit/dorm/{id}")
	public String editDorm(Model model, @PathVariable("id") Long id, @ModelAttribute("dorm") Dorm dorm) {
		Dorm editDorm = dormServ.findDorm(id);
		model.addAttribute("editDorm",editDorm);
		return "editDorm.jsp";
	}
	
	@GetMapping("/dorm/{id}")
	public String findDorm(Model model, @PathVariable("id") Long id) {
		Dorm dorm = dormServ.findDorm(id);
		model.addAttribute("dorm",dorm);
		return "dorm.jsp";
	}
	
	@DeleteMapping("/delete/dorm/{id}")
	public String destroyPerson( @PathVariable("id") Long id) {
		dormServ.deleteDorm(id);
		return "redirect:/dorms";
	}
	
	@PostMapping("/api/dorm/{id}")
	public String updateDorm(Model model, @Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
		if(result.hasErrors()) {
			return "editDorm.jsp";
		}else {
			//flash message
			dormServ.updateDormForm(dorm);
			return "redirect:/dorms";
		}
	}
	
	// ========== STUDENT ==========
	
	@GetMapping("/students")
	public String allStudents(Model model) {
		List<Student> students = studentServ.allStudents();
		model.addAttribute("students",students);
		return "students.jsp";
	}
	
	@GetMapping("/add/student")
	public String addStudent(Model model, @ModelAttribute("student") Student student) {
		List<Dorm> dorms = dormServ.findAllDorms();
		model.addAttribute("dorms", dorms);
		return "addStudent.jsp";
	}
	
	@PostMapping("/api/add/student")
	public String addStudentForm(Model model, @Valid @ModelAttribute("student") Student student, BindingResult result) {
		if(result.hasErrors()) {
			List<Dorm> dorms = dormServ.findAllDorms();
			model.addAttribute("dorms", dorms);
			return "addStudent.jsp";
		}else {
			studentServ.addStudentFrom(student);
			return "redirect:/students";
		}
	}
	
	@GetMapping("/edit/student/{id}")
	public String editStudent(Model model, @PathVariable("id") Long id) {
		Student student = studentServ.findStudent(id);
		List<Dorm> dorms = dormServ.findAllDorms();
		model.addAttribute("dorms", dorms);
		model.addAttribute("student", student);
		return "editStudent.jsp";
	}
		
	@PostMapping("/api/edit/student")
	public String editStudentForm(Model model, @Valid @ModelAttribute("student") Student student, BindingResult result) {
		if(result.hasErrors()) {
			List<Dorm> dorms = dormServ.findAllDorms();
			model.addAttribute("dorms", dorms);
			return "addStudent.jsp";
		}else {
			studentServ.editStudentFrom(student);
			return "redirect:/students";
		}
	}
	
	@DeleteMapping("/delete/student/{id}")
	public String destroyStudent( @PathVariable("id") Long id) {
		studentServ.deleteStudent(id);
		return "redirect:/students";
	}
	
}

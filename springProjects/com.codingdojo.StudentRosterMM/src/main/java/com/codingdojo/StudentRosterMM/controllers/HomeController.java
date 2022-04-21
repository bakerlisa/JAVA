package com.codingdojo.StudentRosterMM.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.StudentRosterMM.models.Course;
import com.codingdojo.StudentRosterMM.models.Student;
import com.codingdojo.StudentRosterMM.models.StudentCourse;
import com.codingdojo.StudentRosterMM.services.CourseService;
import com.codingdojo.StudentRosterMM.services.StudentCourseService;
import com.codingdojo.StudentRosterMM.services.StudentService;

@Controller
public class HomeController {
	private final StudentService stuSer;
	private final CourseService coSer;
	private final StudentCourseService stCoSer;
	
	public HomeController(StudentService stuSer, CourseService coSer,StudentCourseService stCoSer){
		this.stuSer = stuSer;
		this.coSer = coSer;
		this.stCoSer = stCoSer;
	}
	
	// ============================= Gerneral =============================
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard.jsp";
	}
	
	// ============================= Student =============================
	@GetMapping("/students")
	public String students(Model model) {
		List<Student> students = stuSer.allStudents();
		model.addAttribute("students",students);
		return "students.jsp";
	}
	
	@GetMapping("/student/{id}")
	public String student(Model model, @ModelAttribute("studentcourse") StudentCourse studentcourse, @PathVariable("id")Long id) {
		Student student = stuSer.singleStudent(id);
		List<Course> courses = coSer.allClassMembers(student);
		model.addAttribute("courses",courses);
		model.addAttribute("student",student);
		return "student.jsp";
	}
	
	@GetMapping("/add/student")
	public String addStudent(Model model, @ModelAttribute("student") Student student) {
		return "addStudent.jsp";
	}
	
	@PostMapping("/api/add/student")
	public String addStudentForm(Model model, @Valid @ModelAttribute("student") Student student, BindingResult result) {
		if(result.hasErrors()) {
			return "addStudent.jsp";
		}else {
			stuSer.createStudent(student);
			return "redirect:/students";
		}
	}
	
	// ============================= Class =============================
	@GetMapping("/classes")
	public String classes(Model model) {
		List<Course> courses = coSer.allCourses();
;		model.addAttribute("courses",courses);
		return "classes.jsp";
	}
	
	@GetMapping("/class/{id}")
	public String course(Model model, @ModelAttribute("studentcourse") StudentCourse studentcourse, @PathVariable("id")Long id) {
		Course course = coSer.singleCourses(id);
		List<Student> members = stuSer.studentsNotContained(course);
		List<Student> currentMembers = stuSer.allClassMembers(course);
		model.addAttribute("members",members);
		model.addAttribute("course",course);
		model.addAttribute("currentMembers",currentMembers);
		return "class.jsp";
	}
	
	@GetMapping("/add/class")
	public String addClass(Model model, @ModelAttribute("course") Course course) {
		return "addClass.jsp";
	}
	
	@PostMapping("/api/add/class")
	public String addClassForm(Model model, @Valid @ModelAttribute("course") Course course, BindingResult result) {
		if(result.hasErrors()) {
			return "addClass.jsp";
		}else {
			coSer.createClass(course);
			return "redirect:/classes";
		}
	}
	
	@GetMapping("/classes/create")
	public String createQuesyClass(Model model, @RequestParam(value="name")String searchQuery) {
		coSer.createClass(new Course(searchQuery));
		return "redirect:/classes";
	}
	
	// ============================= Student / Class =============================
	@PostMapping("/api/add/studentcourse")
	public String addStudentToCourse(Model model, @Valid @ModelAttribute("studentcourse") StudentCourse studentcourse, BindingResult result) {
		if(result.hasErrors()) {
			return "class.jsp";
		}else {
			stCoSer.createStudentClass(studentcourse);
			return "redirect:/classes";
		}
	}
	
	@GetMapping("/students/{id}/add")
	public String createQuesyClass(Model model, @PathVariable("id")Long id, @RequestParam(value="class")Long searchQuery) {
		Student student = stuSer.singleStudent(id);
		Course course = coSer.singleCourses(searchQuery);
		stCoSer.createStudentClass(new StudentCourse(student,course));
		return "redirect:/classes";
	}
}

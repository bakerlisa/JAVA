package com.codingdojo.books.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.books.models.LoginUser;
import com.codingdojo.books.models.User;
import com.codingdojo.books.services.UserService;

@Controller
public class HomeController {
	
	private final UserService userSer;
	 public HomeController(UserService userSer) {
		 super();
		 this.userSer = userSer;
	 }
	
	// ================ GENERAL ================
		@GetMapping("/")
		public String index(Model model,HttpSession session) {
			if(session.getAttribute("user_id") != null ) {
				return "dashboard.jsp";
			}else {
				model.addAttribute("newUser", new User());
				model.addAttribute("newLogin", new LoginUser());
				return "index.jsp";
			}
			
		}
		
		@GetMapping("/dashboard")
		public String dashboard(Model model, HttpSession session) {
			if(session.getAttribute("user_id") != null ) {
				return "dashboard.jsp";
			}else {
				return "redirect:/";
			}
		}
		
	
	// ================ LOGIN / REGISTER ================
		@PostMapping("/api/register")
		public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, HttpSession session) {
			
			userSer.register(newUser, result);
			
			if(result.hasErrors()) {
				model.addAttribute("newLogin", new LoginUser());
				return "index.jsp";
			}
			
			session.setAttribute("user_id", newUser.getId());
			return "redirect:/dashboard";
		}
		
		@PostMapping("/api/login")
		public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
			User user = userSer.login(newLogin, result);
			if(result.hasErrors()) {
				model.addAttribute("newUser", new User());
				return "index.jsp";
			}
			
			session.setAttribute("user_id", user.getId());
			return "redirect:/dashboard";
		}
		
		@GetMapping("/logout")
		public String dashboard(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
		
		// ================ BOOK ================
		@GetMapping("/new/book")
		public String newBook(Model model, HttpSession session) {
			if(session.getAttribute("user_id") != null ) {
				return "newBook.jsp";
			}else {
				return "redirect:/";
			}
		
		}
		
		@GetMapping("/edit/book")
		public String editBook(Model model, HttpSession session) {
			if(session.getAttribute("user_id") != null ) {
				return "editBook.jsp";
			}else {
				return "redirect:/";
			}
		}
		
		@GetMapping("/book")
		public String book(Model model, HttpSession session) {
			if(session.getAttribute("user_id") != null ) {
				return "oneBook.jsp";
			}else {
				return "redirect:/";
			}
		}
}

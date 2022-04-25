package com.codingdojo.project.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.project.models.LoginUser;
import com.codingdojo.project.models.User;
import com.codingdojo.project.services.UserService;



@Controller
public class HomeController {
	@Autowired
	private final UserService userSer;
	
	public HomeController(UserService userSer){
		super();
		this.userSer = userSer;
	}
	
	// ================================ GENERAL ================================
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
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
			Long loggedID = (Long) session.getAttribute("user_id");
			User userName = userSer.oneUser(loggedID);
			model.addAttribute("logged",userName);
				return "dashboard.jsp";
			}else {
				return "redirect:/";
			}
		}
	// ================================ LOGIN / REGISTRATION ================================
	@PostMapping("/api/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,BindingResult result, Model model, HttpSession session) {					
		userSer.register(newUser, result);	
		if(result.hasErrors()) {
			String register = "active";
			model.addAttribute("register",register);
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}			
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/dashboard";
	}
						
	@PostMapping("/api/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user = userSer.login(newLogin, result);
		if(result.hasErrors()) {
			String login = "active";
			model.addAttribute("login",login);
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
		
	// ================================ SETTINGS ===============================
	
	
	@GetMapping("/settings")
	public String settings() {
		return "settings.jsp";
	}
	
	// ================================ EDIT ===============================
	@GetMapping("/edit/smuget")
	public String editSmuget() {
		return "editSmuget.jsp";
	}
	
}

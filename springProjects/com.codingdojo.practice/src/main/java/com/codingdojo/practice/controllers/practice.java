package com.codingdojo.practice.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class practice {
	@RequestMapping("/dashboard")
    public String hello(HttpSession session,Model model) {
		if(session.getAttribute("name") != null) {
			String name = (String) session.getAttribute("name");
			model.addAttribute("name",name);
		}
		if(session.getAttribute("email") != null) {
			String email = (String) session.getAttribute("email");
			model.addAttribute("email",email);
		}
		return "index.jsp";
    
	}
	
	@RequestMapping("/logout")
    public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/dashboard";
    }
	
	@RequestMapping("/formSubmit")
    public String formSubmit(HttpSession session,RedirectAttributes redirectAttributes,
    		@RequestParam(value="name") String name,
        	@RequestParam(value="password") String password,
        	@RequestParam(value="confirm") String confirm,
        	@RequestParam(value="email") String email) {
			
			
			if(name.length() == 0 || password.length() == 0 || confirm.length() == 0 || email.length() == 0) {
				if(name.length() == 0) {
					redirectAttributes.addFlashAttribute("nameError", "Name required");
				}else {
					session.setAttribute("name", name);
				}
				if(email.length() == 0) {
					redirectAttributes.addFlashAttribute("emailError", "Email required");
				}else {
					session.setAttribute("email", email);
				}
				if(password.length() == 0) {
					redirectAttributes.addFlashAttribute("passwordError", "Password required");
				}
				if(confirm.length() == 0 || confirm != password) {
					redirectAttributes.addFlashAttribute("confirmError", "Passwords don't match");
				}
				
				
				return "redirect:/dashboard";
			}else {
				session.setAttribute("name", name);
				session.setAttribute("password", password);
				session.setAttribute("email", email);
				
				return "redirect:/formTwo";
			}
    }
	
	@RequestMapping("/formTwo")
    public String formTwo(HttpSession session,Model model) {
		
		String name = (String) session.getAttribute("name");
		String password = (String) session.getAttribute("password");
		String email = (String) session.getAttribute("email");
		
		model.addAttribute("name", name);
		model.addAttribute("password", password);
		model.addAttribute("email", email);
		
		return "form.jsp";

    }
}

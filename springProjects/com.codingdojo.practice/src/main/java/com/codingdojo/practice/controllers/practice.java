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
    public String hello() {
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
		
		if(session.getAttribute("name") == null || 
				session.getAttribute("email") == null || 
				session.getAttribute("password") == null || 
				session.getAttribute("password") != session.getAttribute("confirm")) {
			redirectAttributes.addFlashAttribute("nameError", "You need a name!");
			redirectAttributes.addFlashAttribute("emailError", "You need an email!");
			redirectAttributes.addFlashAttribute("passwordError", "You need a Password!");
			redirectAttributes.addFlashAttribute("confirmError", "Passwords don't match!");
//			if() {
//				redirectAttributes.addFlashAttribute("emailPassword", "You need a Password!");
//			}
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

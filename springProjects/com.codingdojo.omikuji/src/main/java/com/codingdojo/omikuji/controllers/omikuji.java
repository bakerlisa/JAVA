package com.codingdojo.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller


public class omikuji {
	@RequestMapping("/omikuji")
    public String index() {
        return "index.jsp";
    }
	
	@RequestMapping("/back")
    public String back(HttpSession session) {
		
		session.removeAttribute("name");
		session.removeAttribute("number");
		session.removeAttribute("fear");
		session.removeAttribute("city");
		session.removeAttribute("career");
		session.removeAttribute("animal");
		session.removeAttribute("magic");
		session.removeAttribute("sentance");
		 
		return "redirect:/omikuji";
    }
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String login(HttpSession session,
	    @RequestParam(value="name") String name,
	    @RequestParam(value="number") String number,
	    @RequestParam(value="fear") String fear,
	    @RequestParam(value="city") String city,
	    @RequestParam(value="career") String career,
	    @RequestParam(value="animal") String animal,
	    @RequestParam(value="magic") String magic,
	    @RequestParam(value="sentance") String sentance) {
		
		 session.setAttribute("name", name);
		 session.setAttribute("number", number);
		 session.setAttribute("fear", fear);
		 session.setAttribute("city", city);
		 session.setAttribute("career", career);
		 session.setAttribute("animal", animal);
		 session.setAttribute("magic", magic);
		 session.setAttribute("sentance", sentance);
		
	    return "redirect:/show";
	}
	
	@RequestMapping("/show")
    public String show(HttpSession session, Model model) {
		String name = (String) session.getAttribute("name");
		String number = (String) session.getAttribute("number");
		String fear = (String) session.getAttribute("fear");
		String city = (String) session.getAttribute("city");
		String career = (String) session.getAttribute("career");
		String animal = (String) session.getAttribute("animal");
		String magic = (String) session.getAttribute("magic");
		String sentance = (String) session.getAttribute("sentance");
		
		model.addAttribute("name",name);
		model.addAttribute("number",number);
		model.addAttribute("fear",fear);
		model.addAttribute("city",city);
		model.addAttribute("career",career);
		model.addAttribute("animal",animal);
		model.addAttribute("magic",magic);
		model.addAttribute("sentance",sentance);
		
        return "show.jsp";
    }
}

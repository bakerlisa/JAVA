package com.codingdojo.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Count {
    @RequestMapping("/")
    public String index(HttpSession session) {
    	if (session.getAttribute("count") == null) {
    		 session.setAttribute("count", 0);
    	}else {
    		 Integer currentCount = (Integer) session.getAttribute("count");
    		 currentCount++;
    		 session.setAttribute("count", currentCount);
    	}
        return "index.jsp";
    }
    
    @RequestMapping("/counter")
    public String counter(HttpSession session, Model model) {
    	Integer currentCount = (Integer) session.getAttribute("count");
    	 model.addAttribute("counter",currentCount);
    	
        return "counter.jsp";
    }
    
    @RequestMapping("/double")
    public String counterdouble(HttpSession session, Model model) {
    	
    	if (session.getAttribute("count") == null) {
    		session.setAttribute("count", 0);
    	}else {
   		 	Integer currentCount = (Integer) session.getAttribute("count");
   		 	currentCount *= 2;
   		 	model.addAttribute("counter",currentCount);
    	}
    	
        return "double.jsp";
    }
    
   

	 @RequestMapping(value = "/reset", method = RequestMethod.GET)
	   public String redirect(HttpSession session) {
		 	session.setAttribute("count", 0);
		 	return "redirect:counter";
	   }
    
}


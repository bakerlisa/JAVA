package com.codingdojo.date.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {
    @RequestMapping("/")
    public String index(Model model) {
        
        String name = "Grace Hopper";
        String itemName = "Copper wire";
        double price = 5.25;
        String description = "Metal strips, also an illustration of nanoseconds.";
        String vendor = "Little Things Corner Store";
    
    	// Your code here! Add values to the view model to be rendered
    
        return "index.jsp";
    }
    
    @RequestMapping("/date")
    public String date(Model model) {
    	return "date.jsp";
    }
    
    @RequestMapping("/time")
    public String time(Model model) {
    	return "time.jsp";
    }
    

}

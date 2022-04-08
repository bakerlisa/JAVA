package com.codingdojo.daikichi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")

public class homeController {
	@RequestMapping("")
    public String hello() {
            return "Welcome!";
    }
	
	@RequestMapping("/today")
    public String today() {
            return "Today you will find luck in all your endeavors!";
    }
	
	@RequestMapping("/tomorrow")
    public String tomorrow() {
            return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!'";
    }
}	

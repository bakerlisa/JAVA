package com.codingdojo.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")

public class HomeController {

	@RequestMapping("")
	public String index() { 
        return "Hello World iw working!";
	}
	
	@RequestMapping("/world")
	public String world() { 
        return "I've got the whole world in my hands";
	}
}

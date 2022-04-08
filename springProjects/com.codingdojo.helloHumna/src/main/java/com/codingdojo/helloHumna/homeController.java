package com.codingdojo.helloHumna;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {
	
	@RequestMapping("/")
	public String search(@RequestParam(value="name", required=false) String searchQuery, 
			@RequestParam(value="last_name", required=false) String searchQueryTwo,
			@RequestParam(value="times", required=false) String searchQueryThree) {
		
		
		if(searchQueryThree != null) {
			int number = Integer.parseInt(searchQueryThree);
			String message = "";
			for(int i=0;i<number;i++) {
				message += "Hello " + searchQuery + " " + searchQueryTwo + "! ";
			}
			return message;
		}else {
			if(searchQuery != null) {
				return "Hello " + searchQuery;
			}else if(searchQueryTwo != null) {
				return "Hello " + searchQuery + " " + searchQueryTwo;
			}
			return "Hello Human";
		}
		
		
	}
}

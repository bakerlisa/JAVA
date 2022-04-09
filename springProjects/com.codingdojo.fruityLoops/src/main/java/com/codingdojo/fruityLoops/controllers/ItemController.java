package com.codingdojo.fruityLoops.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.fruityLoops.models.Item;


@Controller
public class ItemController {
 
 @RequestMapping("/")
 public String index(Model model) {
     
	 ArrayList<Item> fruits = new ArrayList<Item>();
	 
     fruits.add(new Item("Hopping Harrys", 1.5));
     fruits.add(new Item("Mysterious Magpies", 2.0));
     fruits.add(new Item("Curious Carries", 4.0));
     fruits.add(new Item("Exocit Elis", .75));
     
     // Add fruits your view model here
     model.addAttribute("fruits", fruits);
     
     return "index.jsp";
 }
}



package com.codingdojo.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.mvc.models.Book;

@Controller
public class MVC {
	@RequestMapping("/")
	 public String index() {
	     return "index.jsp";
	 }
}

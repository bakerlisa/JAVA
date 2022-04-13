package com.codingdojo.booksTwo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.booksTwo.models.Book;
import com.codingdojo.booksTwo.services.BookServices;

@Controller
public class BookController {
	
	@Autowired
	BookServices bookServices;
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/book/{bookId}")
	public String book(Model model, @PathVariable("bookId") Long bookId) {
		Book book = bookServices.findBook(bookId);
		model.addAttribute("book",book);
		return "show.jsp";
	}
}

package com.codingdojo.booksTwo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String singleBook(Model model, @PathVariable("bookId") Long bookId) {
		Book book = bookServices.findBook(bookId);
		model.addAttribute("book",book);
		return "show.jsp";
	}
	
	@RequestMapping("/books")
	public String allBooks(Model model) {
		List<Book> books = bookServices.allBooks();
		model.addAttribute("books", books);
		return "allBooks.jsp";
	}
	
	@GetMapping("/book/create")
	public String book( @ModelAttribute("book") Book book) {
		return "create.jsp";
	}
	
//	@RequestMapping("/api/create")
//	public String create(Model model,
//			@RequestParam(value="title") String title,
//			@RequestParam(value="description") String desc,
//			@RequestParam(value="language") String lang,
//			@RequestParam(value="pages") Integer pages) {
//		System.out.println(title + " " + desc + " " + lang + " " + pages + " ");
//		Book book = (Book) new Book(title,desc,lang,pages);
//		bookServices.createBook(book);
//		return "redirect:/books";
//	}
	
	@PostMapping("/api/create")
	public String create(@Valid @ModelAttribute("book") Book book,BindingResult result ) {
		if(result.hasErrors()) {
			return "create.jsp";
		}else {
			bookServices.createBook(book);
		}
		return "redirect:/books";
	}
}

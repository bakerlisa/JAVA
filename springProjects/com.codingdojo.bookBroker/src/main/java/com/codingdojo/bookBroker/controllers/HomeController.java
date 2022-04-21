package com.codingdojo.bookBroker.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.bookBroker.models.Book;
import com.codingdojo.bookBroker.models.LoginUser;
import com.codingdojo.bookBroker.models.User;
import com.codingdojo.bookBroker.services.BookService;
import com.codingdojo.bookBroker.services.UserService;

@Controller
public class HomeController {
	private final BookService bookSer;
	private final UserService userSer;
	
	public HomeController(BookService bookSer,UserService userSer){
		this.bookSer = bookSer;
		this.userSer = userSer;
	}
	
	// ================================ GENERAL ================================
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if(session.getAttribute("user_id") != null ) {
			return "bookmarket.jsp";
		}else {
			model.addAttribute("newUser", new User());
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}	
	}
	
	@GetMapping("/bookmarket")
	public String dashboard(Model model, HttpSession session) {
		if(session.getAttribute("user_id") != null ) {
			Long loggedID = (Long) session.getAttribute("user_id");
			User userName = userSer.oneUser(loggedID);
			List<Book> books = bookSer.allBooks();
			model.addAttribute("books",books);
			model.addAttribute("logged",userName);
			return "bookmarket.jsp";
		}else {
			return "redirect:/";
		}
	}
	

	// ================================ LOGIN / REGISTRATION ================================
	@PostMapping("/api/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,BindingResult result, Model model, HttpSession session) {
					
			userSer.register(newUser, result);
			
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
					
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/bookmarket";
	}
				
	@PostMapping("/api/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user = userSer.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
					
		session.setAttribute("user_id", user.getId());
		return "redirect:/bookmarket";
	}
				
	@GetMapping("/logout")
	public String dashboard(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
				
	// ================================ Book ================================
	@GetMapping("/add/book")
	public String addBook(Model model, @ModelAttribute("book")Book book) {
		return "addBook.jsp";
	}
	@GetMapping("/update/book")
	public String updateBook(Model model) {
		return "updateBook.jsp";
	}
	@GetMapping("/book")
	public String book(Model model) {
		return "book.jsp";
	}
	@PostMapping("/api/add/book")
	public String addBookForm(Model model, @Valid @ModelAttribute("book")Book book, BindingResult result ) {
		if(result.hasErrors()) {
			return "addBook.jsp";
		}else {
			bookSer.createBook(book);
			return "redirect:/bookmarket";
		}
	}
	
	@DeleteMapping("/delete/book/{id}")
	public String destroyBook( @PathVariable("id") Long id) {
		return "redirect:/bookmarket";
	}
	
}

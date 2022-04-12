package com.codingdojo.mvc.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@RestController
public class BooksApi {
	
	private final BookService bookService;
 
 	public BooksApi(BookService bookService){
 		this.bookService = bookService;
 	}
 	
 	@RequestMapping("/api/books")
 		public Iterable<Book> index() {
 		return bookService.allBooks();
 	}
 
 	@RequestMapping(value="/api/books", method=RequestMethod.POST)
 	public Book create(@RequestParam(value="title") String title, 
		 @RequestParam(value="description") String desc, 
		 @RequestParam(value="language") String lang, 
		 @RequestParam(value="pages") Integer pages) {
     	Book book = new Book(title, desc, lang, pages);
     	return bookService.createBook(book);
 	}
 	
 	// other methods removed for brevity
  	 @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
  	 public Book update(@PathVariable("id") Long id, 
  	 		@RequestParam(value="title") String title, 
  	 		@RequestParam(value="description") String desc, 
  	 		@RequestParam(value="language") String lang,
  	 		@RequestParam(value="pages") Integer pages) {
  		 Book book = new Book(id,title,desc,lang,pages);
  	     
  		 return bookService.updateBook(id,title,desc,lang,pages);
  	 }
 
 	@RequestMapping("/api/books/{id}")
 	public Book show(@PathVariable("id") Long id,Model model) {
 		Book book = bookService.findBook(id);
 		return book;
 	}
 	
 	@RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
	 public void destroy(@PathVariable("id") Long id) {
	     bookService.deleteBook(id);
	 }
}

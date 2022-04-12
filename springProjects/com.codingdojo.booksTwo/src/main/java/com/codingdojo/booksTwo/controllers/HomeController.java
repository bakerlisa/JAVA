package com.codingdojo.booksTwo.controllers;
import com.codingdojo.booksTwo.models.Book;
import com.codingdojo.booksTwo.services.BookServices;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	private final BookServices bookServices;
	
    public HomeController(BookServices bookServices){
        this.bookServices = bookServices;
    }
    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookServices.allBooks();
    }
    
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang, 
    		@RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookServices.createBook(book);
    }
    
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookServices.findBook(id);
        return book;
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
    	bookServices.deleteBook(id);
    }
    
 // other methods removed for brevity
    @RequestMapping(value="/api/book/update/{id}", method=RequestMethod.PUT)
    public Book update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer pages) {
        Book book = bookServices.updateBook(id, title, desc, lang, pages);
        return book;
    }
}

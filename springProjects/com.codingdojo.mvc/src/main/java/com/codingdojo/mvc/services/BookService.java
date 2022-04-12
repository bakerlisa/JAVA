package com.codingdojo.mvc.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    // returns all the books
    public Iterable<Book> allBooks() {
        return bookRepository.findAll();
    }
    
    // creates a book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
    
    // update book
    public Book updateBook(Long id, String title, String desc, String lang, Integer pages) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
    	if(optionalBook.isPresent()) {
    		// save the book we find
            Book thisBook = optionalBook.get();
            
            //reset the values
            thisBook.setTitle(title);
            thisBook.setDescription(desc);
            thisBook.setLanguage(lang);
            thisBook.setNumberOfPages(pages);
            
            //save them to the database
            return bookRepository.save(thisBook);
        } else {
            return null;
        }
    }
    
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    // deletes a book
    public void deleteBook(Long id) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            bookRepository.deleteById(id);
        }
    }
}
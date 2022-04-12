package com.codingdojo.booksDemo.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.booksDemo.models.Book;
import com.codingdojo.booksDemo.repositories.BookRepository;

public class BookService {
	// adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    
    // creates a book
    public Book createBook(Book b) {
    	return bookRepository.save(b);
    }
    
    // update a book
    public Book updateBook(Long id, String title, String desc, String lang, Integer pages) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            Book thisBook = optionalBook.get();
            
            thisBook.setTitle(title);
            thisBook.setDescription(desc);
            thisBook.setLanguage(lang);
            thisBook.setNumberOfPages(pages);
            
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

package com.codingdojo.booksTwo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.booksTwo.models.Book;
import com.codingdojo.booksTwo.repositories.bookRepository;

@Service
public class BookServices {
    private final bookRepository BookRepository;
    
    public BookServices(bookRepository BookRepository) {
        this.BookRepository = BookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return BookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return BookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = BookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public void deleteBook(Long id) {
    	BookRepository.deleteById(id);
    }
    
    public Book updateBook(Long id, String title, String desc, String lang, Integer pages) {
    	Optional<Book> optionalBook = BookRepository.findById(id);
    	if(optionalBook.isPresent()) {
    		
            Book thisBook = optionalBook.get();
            
            thisBook.setTitle(title);
            thisBook.setDescription(desc);
            thisBook.setLanguage(lang);
            thisBook.setNumberOfPages(pages);
            
            return BookRepository.save(thisBook);
        } else {
            return null;
        }
    }
}

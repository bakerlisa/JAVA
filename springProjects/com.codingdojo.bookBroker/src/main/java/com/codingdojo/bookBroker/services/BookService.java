package com.codingdojo.bookBroker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.bookBroker.models.Book;
import com.codingdojo.bookBroker.models.User;
import com.codingdojo.bookBroker.repositories.BookRepository;


@Service
public class BookService {
	private final BookRepository bookrepo;
	
	public BookService(BookRepository bookrepo) {
		this.bookrepo = bookrepo;
	}
	
	public List<Book> allBooks(){
		return bookrepo.findAll();
	}
	
	public Book createBook(Book book) {
		return bookrepo.save(book);
	}
	
	public void deleteBook(Long id) {
		bookrepo.deleteById(id);
	}
	
	public Book singleBook(Long id) {
		Optional<Book> optBook = bookrepo.findById(id);
		if(optBook.isPresent()) {
			return optBook.get();
		}else {
			return null;
		}
	}
	
	public Book editBook(Book book) {
		Optional<Book> optBook = bookrepo.findById(book.getId());
		if(optBook.isPresent()) {
			Book thisBook = optBook.get();
			
			thisBook.setAuthor(book.getAuthor());
			thisBook.setTitle(book.getTitle());
			thisBook.setReview(book.getReview());
			thisBook.setId(book.getId());
			
			return bookrepo.save(thisBook);
		}else {
			return null;
		}
	}
	
	public List<Book> findByBooksByUser(User user){
		return bookrepo.findAllByUser(user);
	}
	
	public Book borrowBook(Book book) {
		Optional<Book> optBook = bookrepo.findById(book.getId());
		if(optBook.isPresent()) {
			Book thisBook = optBook.get();
			
			thisBook.setBrowwer(book.getBrowwer());
			thisBook.setId(book.getId());
			
			return bookrepo.save(thisBook);
		}else {
			return null;
		}
	}
}

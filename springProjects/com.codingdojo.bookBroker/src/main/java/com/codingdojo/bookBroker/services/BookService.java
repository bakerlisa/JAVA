package com.codingdojo.bookBroker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.bookBroker.models.Book;
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
}

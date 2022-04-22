package com.codingdojo.bookBroker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.bookBroker.models.Book;
import com.codingdojo.bookBroker.models.User;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
	List<Book> findAll();
	
    List<Book> findAllByUser(User user);
    

}	

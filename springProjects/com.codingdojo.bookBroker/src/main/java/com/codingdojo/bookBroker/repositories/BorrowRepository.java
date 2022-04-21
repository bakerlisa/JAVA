package com.codingdojo.bookBroker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.bookBroker.models.Borrow;

@Repository
public interface BorrowRepository extends CrudRepository<Borrow, Long> {
	List<Borrow> findAll();
}

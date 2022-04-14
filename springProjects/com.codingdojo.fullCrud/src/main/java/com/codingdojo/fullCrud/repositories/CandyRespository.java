package com.codingdojo.fullCrud.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.fullCrud.models.Candy;

@Repository
public interface CandyRespository extends CrudRepository<Candy, Long>{
	List<Candy> findAll();
}

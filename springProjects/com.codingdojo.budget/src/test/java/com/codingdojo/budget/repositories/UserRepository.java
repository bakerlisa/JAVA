package com.codingdojo.budget.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.budget.models.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long>{
List<User> findAll();
	
	Optional<User> findByEmail(String email);
}

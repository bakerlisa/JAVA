package com.codingdojo.joy_bundler.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.joy_bundler.models.Name;
import com.codingdojo.joy_bundler.models.User;
import com.codingdojo.joy_bundler.models.Vote;

@Repository
public interface VotesRepository extends CrudRepository<Vote,Long>{
	
	Optional<Vote> findByUser(User user);
	Optional<Vote> findDistinctByNameAndUser(Name name,User user);
	
	
	
}

package com.codingdojo.exam_joy_bundler.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.exam_joy_bundler.models.Name;
import com.codingdojo.exam_joy_bundler.models.User;
import com.codingdojo.exam_joy_bundler.models.Vote;



@Repository
public interface VoteRepository extends CrudRepository<Vote,Long>{
	
	Optional<Vote> findByUser(User user);
	Optional<Vote> findDistinctByNameAndUser(Name name,User user);
	
	
	
}
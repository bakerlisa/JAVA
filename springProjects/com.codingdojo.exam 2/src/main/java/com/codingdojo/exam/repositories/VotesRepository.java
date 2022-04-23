package com.codingdojo.exam.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.exam.models.Name;
import com.codingdojo.exam.models.User;
import com.codingdojo.exam.models.Vote;

@Repository
public interface VotesRepository extends CrudRepository<Vote,Long>{
	
	Optional<Vote> findByUser(User user);
	Optional<Vote> findDistinctByNameAndUser(Name name,User user);
	
	
	
}

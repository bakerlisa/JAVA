package com.codingdojo.exam_two.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.exam_two.models.Name;
import com.codingdojo.exam_two.models.User;
import com.codingdojo.exam_two.models.Vote;

@Repository
public interface VotesRepository extends CrudRepository<Vote,Long>{
	
	Optional<Vote> findByUser(User user);
	Optional<Vote> findDistinctByNameAndUser(Name name,User user);
	
	
	
}

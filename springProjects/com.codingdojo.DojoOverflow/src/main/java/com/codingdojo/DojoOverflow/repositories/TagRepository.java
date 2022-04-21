package com.codingdojo.DojoOverflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.DojoOverflow.models.Question;
import com.codingdojo.DojoOverflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	List<Tag> findAll();
	
	// Retrieves a list of all categories for a particular product
    List<Tag> findAllByQuestions(Question question);
   
    Optional<Tag> findBySubject(String subject);
}

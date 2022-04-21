package com.codingdojo.DojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.DojoOverflow.models.QuestionsTags;

@Repository
public interface QuestionTagRepository extends CrudRepository<QuestionsTags, Long>{
	List<QuestionsTags> findAll();
}

package com.codingdojo.DojoOverflow.services;

import org.springframework.stereotype.Service;

import com.codingdojo.DojoOverflow.models.QuestionsTags;
import com.codingdojo.DojoOverflow.repositories.QuestionTagRepository;

@Service
public class QuestionTagService {
	private final QuestionTagRepository quesTagRepo;
	
	public QuestionTagService(QuestionTagRepository quesTagRepo) {
		this.quesTagRepo = quesTagRepo;
	}
	public QuestionsTags createQuesTag(QuestionsTags quesTag) {
		return quesTagRepo.save(quesTag);
	}
}

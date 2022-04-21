package com.codingdojo.DojoOverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.DojoOverflow.models.Answer;
import com.codingdojo.DojoOverflow.models.Question;
import com.codingdojo.DojoOverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	private final AnswerRepository ansRepo;
	
	public AnswerService(AnswerRepository ansRepo) {
		this.ansRepo = ansRepo;
	}
	
	public List<Answer> allAnswers(){
		return ansRepo.findAll();
	}
	
	public Answer createAnswer(Answer answer) {
		return ansRepo.save(answer);
	}
	

}

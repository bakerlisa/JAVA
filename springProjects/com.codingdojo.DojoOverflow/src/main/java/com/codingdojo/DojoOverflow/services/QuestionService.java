package com.codingdojo.DojoOverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.DojoOverflow.models.Answer;
import com.codingdojo.DojoOverflow.models.Question;
import com.codingdojo.DojoOverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	private final QuestionRepository quesRepo;
	
	public QuestionService(QuestionRepository quesRepo) {
		this.quesRepo = quesRepo;	
	}
	
	public List<Question> allQuestions(){
		return quesRepo.findAll();
	}
	
	public Question createQuestion(Question question) {
		return quesRepo.save(question);
	}
	
	public Question singleQuestion(Long id) {
		Optional<Question> optQues = quesRepo.findById(id);;
		if(optQues.isPresent()) {
			return optQues.get();
		}else {
			return null;
		}
	}

	
}

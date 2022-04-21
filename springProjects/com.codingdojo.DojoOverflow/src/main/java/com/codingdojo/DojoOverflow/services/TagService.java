package com.codingdojo.DojoOverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.DojoOverflow.models.Question;
import com.codingdojo.DojoOverflow.models.Tag;
import com.codingdojo.DojoOverflow.models.User;
import com.codingdojo.DojoOverflow.repositories.TagRepository;

@Service
public class TagService {
	private TagRepository tagRepo;
	
	public TagService(TagRepository tagRepo) {
		this.tagRepo = tagRepo;
	}
	
	public List<Tag> allAnswers(){
		return tagRepo.findAll();
	}
	
	public Tag createTag(Tag tag) {
		return tagRepo.save(tag);
	}
	
	public List<Tag> findAllTags(Question question){
		return tagRepo.findAllByQuestions(question);
	}
	

	
	public Tag getTagExsist(String subject) {
		Optional<Tag> optTag = tagRepo.findBySubject(subject);
		
//		System.out.println(optTag.empty() != null);
		if(optTag.isPresent()) {
			return optTag.get();
		}else {
			Tag newerTag = new Tag(subject);
			return tagRepo.save(newerTag);
		}
		
	}
}

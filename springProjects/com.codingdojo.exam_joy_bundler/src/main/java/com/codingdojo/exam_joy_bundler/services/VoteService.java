package com.codingdojo.exam_joy_bundler.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.exam_joy_bundler.models.Vote;
import com.codingdojo.exam_joy_bundler.repositories.VoteRepository;



@Service
public class VoteService {
	private final VoteRepository voteRepo;
	
	public VoteService(VoteRepository voteRepo) {
		this.voteRepo =  voteRepo;
	}
	
	public Vote castVote(Vote vote) {
		Optional<Vote> optVote = voteRepo.findDistinctByNameAndUser(vote.getName() ,vote.getUser());
		System.out.println("present");
		
		if(optVote.isPresent()) {
			Vote thisVote = optVote.get();
			voteRepo.deleteById(thisVote.getId());
			return null;
		}else {
			return voteRepo.save(vote);
		}
	}
	
	public int voteCount(){ return (int) voteRepo.count(); }
}
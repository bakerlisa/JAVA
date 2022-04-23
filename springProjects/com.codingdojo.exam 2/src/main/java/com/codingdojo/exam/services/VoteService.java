package com.codingdojo.exam.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.exam.models.Vote;
import com.codingdojo.exam.repositories.VotesRepository;

@Service
public class VoteService {
	private final VotesRepository voteRepo;
	
	public VoteService(VotesRepository voteRepo) {
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

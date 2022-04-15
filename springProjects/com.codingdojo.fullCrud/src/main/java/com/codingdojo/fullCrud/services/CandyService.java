package com.codingdojo.fullCrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.fullCrud.models.Candy;
import com.codingdojo.fullCrud.repositories.CandyRespository;


@Service
public class CandyService {
	
	private final CandyRespository candyRepo;
	
	 public CandyService(CandyRespository candyRepo) {
	        this.candyRepo = candyRepo;
	    }
	 
	 	// all candies
	    public List<Candy> allCandies() {
	    	return candyRepo.findAll();
	    }
	    
	    // creates a candy
	    public Candy createCandy(Candy candy) {
	        return candyRepo.save(candy);
	    }
	    
	    // find one candy by ID
	    public Candy findCandy(Long id) {
	        Optional<Candy> optionalCandy = candyRepo.findById(id);
	        if(optionalCandy.isPresent()) {
	            return optionalCandy.get();
	        } else {
	            return null;
	        }
	    }
	    
	    
	    //delete candy
	    public void deleteCandy(Long id) {
	    	candyRepo.deleteById(id);
	    }
	    
	    //update candy
	    public Candy updateCandy(Candy candy) {
	    	Optional<Candy> optionalCandy = candyRepo.findById(candy.getId());
	    	
	    	if(optionalCandy.isPresent()) {
	    		
	    		Candy thisCandy = optionalCandy.get();
	            
	    		thisCandy.setName(candy.getName());
	    		thisCandy.setRating(candy.getRating());
	    		thisCandy.setPrice(candy.getPrice());
	    		thisCandy.setBrand(candy.getBrand());
	            
	            return candyRepo.save(thisCandy);
	        } else {
	            return null;
	        }
	    }
}

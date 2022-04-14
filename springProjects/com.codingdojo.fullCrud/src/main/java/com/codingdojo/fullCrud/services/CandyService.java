package com.codingdojo.fullCrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.fullCrud.models.Candy;
import com.codingdojo.fullCrud.repositories.CandyRespository;


@Service
public class CandyService {
	
	private final CandyRespository candyRespository;
	
	 public CandyService(CandyRespository candyRespository) {
	        this.candyRespository = candyRespository;
	    }
	 
	
	    public List<Candy> allCandies() {
	    	return candyRespository.findAll();
	    }
	    
	    
	    // creates a expense
	    public Candy createCandy(Candy candy) {
	        return candyRespository.save(candy);
	    }
	    
	    // retrieves a expense
	    public Candy findCandy(Long id) {
	        Optional<Candy> optionalCandy = candyRespository.findById(id);
	        if(optionalCandy.isPresent()) {
	            return optionalCandy.get();
	        } else {
	            return null;
	        }
	    }
	    
	    public void deleteExpense(Long id) {
	    	candyRespository.deleteById(id);
	    }
	    
	    public Candy updateExpense(Candy expense) {
	    	Optional<Candy> optionalCandy = candyRespository.findById(expense.getId());
	    	
	    	if(optionalCandy.isPresent()) {
	    		
	    		Candy thisCandy = optionalCandy.get();
	            
	    		thisCandy.setName(expense.getName());
	    		thisCandy.setRating(expense.getRating());
	    		thisCandy.setPrice(expense.getPrice());
	    		thisCandy.setBrand(expense.getBrand());
	            
	            return candyRespository.save(thisCandy);
	        } else {
	            return null;
	        }
	    }
}

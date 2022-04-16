package com.codingdojo.lookfy.services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.codingdojo.lookfy.models.Lookify;
import com.codingdojo.lookfy.repositories.LookifyRepository;

@Service
public class LookifyService {
	private final LookifyRepository lookifyRepo;
	
	public LookifyService(LookifyRepository lookifyRepo) {
		this.lookifyRepo = lookifyRepo;
	}
	
	public List<Lookify> allLookys(){
		return lookifyRepo.findAll();
	}
	
	public Lookify createLooky(Lookify lookify) {
        return lookifyRepo.save(lookify);
    }
	
	public void deleteSong(Long id) {
		lookifyRepo.deleteById(id);
	}
	
}

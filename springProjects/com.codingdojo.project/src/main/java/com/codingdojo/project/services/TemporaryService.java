package com.codingdojo.project.services;

import org.springframework.stereotype.Service;

import com.codingdojo.project.models.Temporary;
import com.codingdojo.project.repositories.TemporaryRepository;

@Service
public class TemporaryService {
	private final TemporaryRepository tempRepo;
	
	public TemporaryService(TemporaryRepository tempRepo) {
		this.tempRepo = tempRepo;
	}
	
	public Temporary createTemp(Temporary temporary) {
		return tempRepo.save(temporary);
	}
	
}

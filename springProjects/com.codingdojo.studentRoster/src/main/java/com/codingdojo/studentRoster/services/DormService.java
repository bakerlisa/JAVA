package com.codingdojo.studentRoster.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.studentRoster.models.Dorm;
import com.codingdojo.studentRoster.repositories.DormRepository;

@Service
public class DormService {
	private final DormRepository dormRepo;
	
	public DormService(DormRepository dormRepo){
		this.dormRepo = dormRepo;
	}
	
	public List<Dorm> findAllDorms(){
		return dormRepo.findAll();
	}
	
	public Dorm addNewDorm(Dorm dorm) {
		return dormRepo.save(dorm);
	}
}

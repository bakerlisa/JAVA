package com.codingdojo.studentRoster.services;

import java.util.List;
import java.util.Optional;

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
	
	public void deleteDorm(Long id) {
		dormRepo.deleteById(id);
	}
	
	public Dorm findDorm(Long id) {
		Optional<Dorm> optDorm = dormRepo.findById(id);
		if(optDorm.isPresent()) {
			return optDorm.get();
		}else {
			return null;
		}
	}
	
	public Dorm updateDormForm(Dorm dorm) {
		Optional<Dorm> optDorm = dormRepo.findById(dorm.getId());
		if(optDorm.isPresent()) {
			Dorm thisDorm = optDorm.get();
			
			thisDorm.setName(dorm.getName());

			return dormRepo.save(thisDorm);
		}else {
			return null;
		}
	}
}

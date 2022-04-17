package com.codingdojo.dojosNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosNinjas.models.Dojo;
import com.codingdojo.dojosNinjas.models.Ninja;
import com.codingdojo.dojosNinjas.repositories.DojoRepository;

@Service
public class DojoService {
	private DojoRepository dojoReop;
	
	public DojoService(DojoRepository dojoReop) {
		this.dojoReop = dojoReop;
	}
	
	public List<Dojo >allDojos() {
		return dojoReop.findAll();
	}
	
	public Dojo singleDojoInfo(Long id) {
		Optional<Dojo> optDojo = dojoReop.findById(id);
		if(optDojo.isPresent()) {
			return optDojo.get();
		}else {
			return null;
		}
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoReop.save(dojo);
		
	}
	
	public void deleteDojo(Long id) {
		dojoReop.deleteById(id);
	}
	
	public List<Ninja> allDojoNinjas(Long id){
		return null;
	}
}

package com.codingdojo.dojosNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosNinjas.models.Ninja;
import com.codingdojo.dojosNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private NinjaRepository ninjaReop;
	
	public NinjaService(NinjaRepository ninjaReop) {
		super();
		this.ninjaReop = ninjaReop;
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaReop.save(ninja);
	}
	
	public List<Ninja> allNinjas(){
		return ninjaReop.findAll();
	}
	
	public void deleteNinja(Long id) {
		ninjaReop.deleteById(id);
	}
}

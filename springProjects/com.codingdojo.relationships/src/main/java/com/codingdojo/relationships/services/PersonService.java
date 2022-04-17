package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personReop;

	public PersonService(PersonRepository personReop){
		this.personReop = personReop;
	}
	
	public List<Person> allPeople(){
		return personReop.findAll();
	}
	
	public Person findPerson(Long id) {
		Optional<Person> person = personReop.findById(id);
		if(person.isPresent()) {
			return person.get();
		}else {			
			return null;
		}
	}
	
	public Person createPerson(Person person) {
		return personReop.save(person);
	}
	
	public void deletePerson(Long id) {
		personReop.deleteById(id);
	}
	
}

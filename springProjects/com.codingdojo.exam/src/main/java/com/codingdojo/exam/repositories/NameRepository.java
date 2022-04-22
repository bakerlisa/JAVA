package com.codingdojo.exam.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.exam.models.Name;


@Repository
public interface NameRepository extends CrudRepository<Name,Long> {
	List<Name> findAll();
	

	Optional<Name> findByGivenname(String name);
}

package com.codingdojo.loginRegistration.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.loginRegistration.models.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long>{
	List<Users> findAll();
}

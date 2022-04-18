package com.codingdojo.loginRegistration.services;

import org.springframework.stereotype.Service;

import com.codingdojo.loginRegistration.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
}

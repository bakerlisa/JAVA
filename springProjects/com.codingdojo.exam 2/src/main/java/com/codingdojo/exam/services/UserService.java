package com.codingdojo.exam.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.exam.models.LoginUser;
import com.codingdojo.exam.models.User;
import com.codingdojo.exam.repositories.UserRepository;


@Service
public class UserService {
	@Autowired
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	//find one User
	public User oneUser(Long id) {
		Optional<User> optUser = userRepo.findById(id);
		if(optUser.isPresent()) {
			return optUser.get();
		}else {
			return null;
		}
	}
	
	// method to register
	public User register(User newUser, BindingResult result) {
		
		if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email","Unquie","You better think of a new email");
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())){
			result.rejectValue("confirm","Matches","Passwords do not match");
		}
		if(result.hasErrors()) {			
			return null;
		}else {
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashed);
			
			return userRepo.save(newUser);
		}
	}
	
	// method for login
	public User login(LoginUser newLogin, BindingResult result) {
		if(result.hasErrors()) {			
			return null;
		}
		
		Optional<User> potentiallUser = userRepo.findByEmail(newLogin.getEmail());
		if(!potentiallUser.isPresent()) {
			System.out.println("not present");
			result.rejectValue("email","notFound","Email not found");
			return null;
		}
		
		
		User user = potentiallUser.get();
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password","Matches","Is this really your account?");
		}	
		
		if(result.hasErrors()) {
			return null;
		}else {
			return user;
		}	
	}
	
	
}

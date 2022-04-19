package com.codingdojo.loginRegistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.loginRegistration.models.LoginUser;
import com.codingdojo.loginRegistration.models.Users;
import com.codingdojo.loginRegistration.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	//find one User
	public Users oneUser(Long id) {
		Optional<Users> optUser = userRepo.findById(id);
		if(optUser.isPresent()) {
			return optUser.get();
		}else {
			return null;
		}
	}
	
	// method to register
	public Users register(Users newUser, BindingResult result) {
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
	public Users login(LoginUser newLogin, BindingResult result) {
		if(result.hasErrors()) {			
			return null;
		}
		
		Optional<Users> potentialUser = userRepo.findByEmail(newLogin.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email","Unquie","We have not record of this email");
		}
		
		Users user = potentialUser.get();
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("confirm","Matches","Is this really your account?");
		}	
		
		if(result.hasErrors()) {
			return null;
		}else {
			return user;
		}
		
	}
	
	
}

package com.codingdojo.PlantKeeper.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//No Entity
public class LoginUser {
	
	@NotEmpty
	@Email(message="Please use  valid email")
	private String email;
	
	@NotEmpty
	@Size(min=8,max=128,message="password must be bweet 8-128 characters")
	private String password;

	// CONSTRUCTORS
	public LoginUser() {
		super();
	}
	
	public LoginUser(@NotEmpty @Email(message = "Please use  valid email") String email,
			@NotEmpty @Size(min = 8, max = 128, message = "password must be bweet 8-128 characters") String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	// GETTERS / SETTERS
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

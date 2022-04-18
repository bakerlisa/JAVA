package com.codingdojo.loginRegistration.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class Users {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Size(min=0,max=25,message="Username cannot be blank")
	private String user;
	
	@NotNull
	@Email(message="Email cannot be blank")
	private String Email;
	
	@NotNull
	@Size(min=8,max=128,message="password needs to be between 8-128 characters")
	private String password;
	
	@Transient
	@NotEmpty(message="Confirm Password is required!")
	@Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
	private String confirm;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

	//CONSTRUCTORS
	public Users(@NotNull @Size(min = 0, max = 25, message = "Username cannot be blank") String user,
			@NotNull @javax.validation.constraints.Email(message = "Email cannot be blank") String email,
			@NotNull @Size(min = 8, max = 128, message = "password needs to be between 8-128 characters") String password,
			@NotEmpty(message = "Confirm Password is required!") @Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters") String confirm) {
		super();
		this.user = user;
		Email = email;
		this.password = password;
		this.confirm = confirm;
	}

	public Users() {
		super();
	}
	
	// GETTERS / SETTERS
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}


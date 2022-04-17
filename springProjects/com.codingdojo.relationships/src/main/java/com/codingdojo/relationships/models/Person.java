package com.codingdojo.relationships.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="persons")
public class Person {
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Size(min=2,max=25,message="First Name cannot be empty")
	private String firstName;
	
	@NotNull
	@Size(min=2,max=25,message="First Name cannot be empty")
	private String lastName;
 
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // ===== RELATIONSHIPS =====
    @OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private License license;
 
    // ===== CONSTRUCTORS =====
	public Person() {
		super();
	}
	
	public Person(String firstName, String lastName, License license) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.license = license;
	}

	public Person(License license) {
		super();
		this.license = license;
	}
	public Person(@NotNull @Size(min = 2, max = 50, message = "First name cannot be blank") String firstName,
			@NotNull @Size(min = 2, max = 50, message = "Last name cannot be blank") String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Person(Long id, @NotNull @Size(min = 2, max = 50, message = "First name cannot be blank") String firstName,
			@NotNull @Size(min = 2, max = 50, message = "Last name cannot be blank") String lastName, Date createdAt,
			Date updatedAt, License license) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.license = license;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	// GETTERS / SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public License getLicense() {
		return license;
	}
	public void setLicense(License license) {
		this.license = license;
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



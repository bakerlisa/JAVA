package com.codingdojo.dojosNinjas.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninja")
public class Ninja {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2,max=25,message="First name cannot be empty")
	private String firstName;
	
	@NotNull
	@Size(min=2,max=25,message="Last Name cannot be empty")
	private String lastName;

	@NotNull(message="Age cannot be empty")
	@Min(1)
	private int age;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // CONSTRUCTORS
    public Ninja() {
		super();
	}
    public Ninja(Dojo dojo) {
		super();
		this.dojo = dojo;
	}
    public Ninja(Long id, @NotNull @Size(min = 2, max = 25, message = "First name cannot be empty") String firstName,
			@NotNull @Size(min = 2, max = 25, message = "Last Name cannot be empty") String lastName,
			@NotNull(message = "Age cannot be empty") @Min(1) int age, Dojo dojo, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dojo = dojo;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Ninja(Long id, @NotNull @Size(min = 2, max = 25, message = "First name cannot be empty") String firstName,
			@NotNull @Size(min = 2, max = 25, message = "Last Name cannot be empty") String lastName,
			@NotNull(message = "Age cannot be empty") @Min(1) int age, Dojo dojo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dojo = dojo;
	}
	public Ninja(@NotNull @Size(min = 2, max = 25, message = "First name cannot be empty") String firstName,
			@NotNull @Size(min = 2, max = 25, message = "Last Name cannot be empty") String lastName,
			@NotNull(message = "Age cannot be empty") @Min(1) int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Dojo getDojo() {
		return dojo;
	}
	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
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
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
 	
}

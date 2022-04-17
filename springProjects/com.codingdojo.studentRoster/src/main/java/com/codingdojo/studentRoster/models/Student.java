package com.codingdojo.studentRoster.models;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2,max=25,message="First Name cannot be black")
	private String firstName;
	
	@NotNull
	@Size(min=2,max=25,message="Last Name cannot be blank")
	private String lastName;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    //RELATIONSHIPS
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dorm_id")
    private Dorm dorm;
    
    // CONSTRUCTORS
    public Student() {
		super();
	}
    public Student(Long id, @NotNull @Size(min = 2, max = 25, message = "First Name cannot be black") String firstName,
			@NotNull @Size(min = 2, max = 25, message = "Last Name cannot be blank") String lastName, Date createdAt,
			Date updatedAt, Dorm dorm) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.dorm = dorm;
	}
	public Student(Long id, @NotNull @Size(min = 2, max = 25, message = "First Name cannot be black") String firstName,
			@NotNull @Size(min = 2, max = 25, message = "Last Name cannot be blank") String lastName, Dorm dorm) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dorm = dorm;
	}
	public Student(@NotNull @Size(min = 2, max = 25, message = "First Name cannot be black") String firstName,
			@NotNull @Size(min = 2, max = 25, message = "Last Name cannot be blank") String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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
	public void setUpdatesdAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Dorm getDorm() {
		return dorm;
	}
	public void setDorm(Dorm dorm) {
		this.dorm = dorm;
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

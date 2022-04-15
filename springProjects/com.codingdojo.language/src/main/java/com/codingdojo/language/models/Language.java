package com.codingdojo.language.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="language")
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2,max=20,message="Name needs between 2-20 charactes")
	private String name;
	
	@NotNull
	@Size(min=2,max=20,message="Creator must be between 2-20 characters")
	private String creator;
	
	@NotNull(message="Version cannont be null")
	private Double version;
	
	// This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    //CONSTRUCTORS
    public Language() {
    	super();
    }
	public Language(Long id,
			@NotNull @Size(min = 2, max = 20, message = "Name needs between 2-20 charactes") String name,
			@NotNull @Size(min = 2, max = 20, message = "Creator must be between 2-20 characters") String creator,
			@NotNull(message = "Version cannont be null") Double version, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.creator = creator;
		this.version = version;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Language(@NotNull @Size(min = 2, max = 20, message = "Name needs between 2-20 charactes") String name,
			@NotNull @Size(min = 2, max = 20, message = "Creator must be between 2-20 characters") String creator,
			@NotNull(message = "Version cannont be null") Double version) {
		super();
		this.name = name;
		this.creator = creator;
		this.version = version;
	}
	
	//GETTERS/SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Double getVersion() {
		return version;
	}
	public void setVersion(Double version) {
		this.version = version;
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

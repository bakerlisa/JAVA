package com.codingdojo.relationships.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="licenses")
public class License {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
 
	@NotNull
	@Size(min=2,max=15,message="Number cannot be blank")
	private String number;
 
	@NotNull(message="Date cannot be blank")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expirationDate;
 
	@NotNull
	@Size(min=2,max=15,message="State cannot be blank")
	private String state;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
 
    // ===== RELATIONSHIPS =====
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="person_id")
	private Person person;
	
	// ===== CONSTRUCTORS =====
	public License() {
		super();
	}
	public License(Person person) {
		super();
		this.person = person;
	}
	public License(@NotNull String number, Date expirationDate,
			@NotNull @Size(min = 2, max = 15, message = "State cannot be blank") String state) {
		super();
		this.number = number;
		this.expirationDate = expirationDate;
		this.state = state;
	}
	public License(Long id, @NotNull String number, Date expirationDate,
			@NotNull @Size(min = 2, max = 15, message = "State cannot be blank") String state, Date createdAt,
			Date updatedAt, Person person) {
		super();
		this.id = id;
		this.number = number;
		this.expirationDate = expirationDate;
		this.state = state;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.person = person;
	}
	
	public License(@NotNull @Size(min = 2, max = 15, message = "Number cannot be blank") String number,
			@NotNull(message = "Date cannot be blank") Date expirationDate,
			@NotNull @Size(min = 2, max = 15, message = "State cannot be blank") String state, Person person) {
		super();
		this.number = number;
		this.expirationDate = expirationDate;
		this.state = state;
		this.person = person;
	}
	
	// ===== GETTERS / SEETTERS =====
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	// GETTERS / SETTERS
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
}



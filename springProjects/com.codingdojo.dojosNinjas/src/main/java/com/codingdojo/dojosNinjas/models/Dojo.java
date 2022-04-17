package com.codingdojo.dojosNinjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojo")
public class Dojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2,max=15,message="Dojo cannot be blank")
	private String name;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    private List<Ninja> ninjas;
    
    // CONSTRUCTORS
    public Dojo() {
		super();
	}
	public Dojo(@NotNull @Size(min = 2, max = 15, message = "Dojo cannot be blank") String name) {
		super();
		this.name = name;
	}
	public Dojo(Long id, @NotNull @Size(min = 2, max = 15, message = "Dojo cannot be blank") String name,
			List<Ninja> ninjas) {
		super();
		this.id = id;
		this.name = name;
		this.ninjas = ninjas;
	}
    public Dojo(Long id, @NotNull @Size(min = 2, max = 15, message = "Dojo cannot be blank") String name,
			Date createdAt, Date updatedAt, List<Ninja> ninjas) {
		super();
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.ninjas = ninjas;
	}
    
    // GETTERS / SETTERS
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
	public List<Ninja> getNinjas() {
		return ninjas;
	}
	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
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

package com.codingdojo.fullCrud.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="candy")
public class Candy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
    @Size(min = 3, max = 30, message="Can't be blank")
	private String name;
	
	@NotNull
    @Size(min = 3, max = 15, message="Can't be blank")
	private String brand;
	
	@NotNull(message="Please add a rating")
	@Max(10)
	@Min(0)
	private Integer rating;
	
	@NotNull(message="Price cannot be blank")
	@Max(10)
	@Min(1)
	private Double price;
	
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // CONSTRUCTORS
    public Candy() {
		super();
	}
    
    public Candy(Long id, @NotNull @Size(min = 3, max = 30, message = "Can't be blank") String name, @NotNull @Size(min = 3, max = 15, message = "Can't be blank") String brand, @NotNull(message = "Please add a rating") @Max(10) @Min(0) Integer rating, @NotNull(message = "Price cannot be blank") @Max(10) @Min(1) Double price, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.rating = rating;
		this.price = price;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Candy(@NotNull @Size(min = 3, max = 30, message = "Can't be blank") String name, @NotNull @Size(min = 3, max = 15, message = "Can't be blank") String brand, @NotNull(message = "Please add a rating") @Max(10) @Min(0) Integer rating, @NotNull(message = "Price cannot be blank") @Max(10) @Min(1) Double price) {
		super();
		this.name = name;
		this.brand = brand;
		this.rating = rating;
		this.price = price;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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


package com.codingdojo.ProductsCategorys.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2,max=50,message="Product name cannot be blank")
	private String name;
	
	@NotNull
	@Size(min=2,max=200,message="Description cannot be blank")
	private String description;
	
	@NotNull
	@Min(1)
	private double price;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // REALTIONSHIPS
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name = "categories_products", 
    		joinColumns = @JoinColumn(name = "product_id"), 
    		inverseJoinColumns = @JoinColumn(name = "category_id")
	)
    private List<Category> categories;
    
    
    // CONTRRUCTORS
    public Product() {
		super();
	}
	
	public Product(List<Category> categories) {
		super();
		this.categories = categories;
	}
	public Product(Long id, @NotNull @Size(min = 2, max = 50, message = "Product name cannot be blank") String name,
			@NotNull @Size(min = 2, max = 200, message = "Description cannot be blank") String description,
			@NotNull @Min(1) double price, Date createdAt, Date updatedAt, List<Category> categories) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.categories = categories;
	}
	public Product(@NotNull @Size(min = 2, max = 50, message = "Product name cannot be blank") String name,
			@NotNull @Size(min = 2, max = 200, message = "Description cannot be blank") String description,
			@NotNull @Min(1) double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
    // GETTER / SETTERS
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
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

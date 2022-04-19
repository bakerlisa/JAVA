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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2,max=25,message="Name cannot be blank")
	private String name;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // REALTIONSHIPS
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "categories_products", 
        joinColumns = @JoinColumn(name = "category_id"), 
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
    
    // CONTRRUCTORS
    public Category() {
		super();
	}

	public Category(@NotNull @Size(min = 2, max = 25, message = "Name cannot be blank") String name) {
		super();
		this.name = name;
	}
	
	public Category(List<Product> products) {
		super();
		this.products = products;
	}

	public Category(Long id, @NotNull @Size(min = 2, max = 25, message = "Name cannot be blank") String name,
			List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
	}
	
    public Category(Long id, @NotNull @Size(min = 2, max = 25, message = "Name cannot be blank") String name,
			Date createdAt, Date updatedAt, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.products = products;
	}

    // GETTER / SETTERS
	public Long getId() {
		return id;
	}

	public void category(Long id) {
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
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

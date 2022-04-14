package com.codingdojo.fullCrud.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @Size(min = 5, max = 200, message="Can't be blank")
    private String title;
    
    @NotNull
    @Size(min = 5, max = 200, message="Description can't be blank")
    private String description;
    
    @NotNull
    @Size(min = 5, max = 200, message="vendor between 5 - 200 characters")
    private String vendor;
    
    @NotNull(message="amount cannot be blank")
    @Min(0)
    private Double amount;
    
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
}

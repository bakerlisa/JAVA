package com.codingdojo.studentRoster.models;

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
@Table(name="dorm")
public class Dorm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2,max=25,message="Dorm needs a name")
	private String name;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // RELATIONSHIPS
    @OneToMany(mappedBy="dorm", fetch = FetchType.LAZY)
    private List<Student> students;
    
    // CONSTRUCTORS
    public Dorm() {
		super();
	}
    public Dorm(@NotNull @Size(min = 2, max = 25, message = "Dorm needs a name") String name, List<Student> students) {
		super();
		this.name = name;
		this.students = students;
	}

	public Dorm(@NotNull @Size(min = 2, max = 25, message = "Dorm needs a name") String name) {
		super();
		this.name = name;
	}
	
    public Dorm(Long id, @NotNull @Size(min = 2, max = 25, message = "Dorm needs a name") String name, Date createdAt,
    		Date updatedAt, List<Student> students) {
    	super();
    	this.id = id;
    	this.name = name;
    	this.createdAt = createdAt;
    	this.updatedAt = updatedAt;
    	this.students = students;
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
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
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

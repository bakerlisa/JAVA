package com.codingdojo.DojoOverflow.models;

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
@Table(name="tag")
public class Tag {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Size(min=2,max=25,message="Tag cannont be empty")
	private String subject;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // =========== RELATIONSHIPS ===========
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "questions_tags", 
        joinColumns = @JoinColumn(name = "tag_id"), 
        inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions;
    
    // =========== CONSTRUCTORS ===========
    public Tag() {
		super();
	}
	public Tag(Long id, @NotNull @Size(min = 2, max = 25, message = "Tag cannont be empty") String subject,
			Date createdAt, Date updatedAt, List<Question> questions) {
		super();
		this.id = id;
		this.subject = subject;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.questions = questions;
	}
	public Tag(@NotNull @Size(min = 2, max = 25, message = "Tag cannont be empty") String subject,
			List<Question> questions) {
		super();
		this.subject = subject;
		this.questions = questions;
	}
	public Tag(@NotNull @Size(min = 2, max = 25, message = "Tag cannont be empty") String subject) {
		super();
		this.subject = subject;
	}
	
    // =========== GETTERS / SETTERS ===========
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
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

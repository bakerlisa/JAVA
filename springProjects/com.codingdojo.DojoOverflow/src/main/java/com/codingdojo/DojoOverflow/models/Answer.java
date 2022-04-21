package com.codingdojo.DojoOverflow.models;

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
@Table(name="answer")
public class Answer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Size(min=2,max=200,message="Answer cannot be blank")
	private String userAnswer;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
    //RELATIONSHIPS
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
    private Question question;
    
    // CONSTRUCTORS
    public Answer(@NotNull @Size(min = 2, max = 200, message = "Answer cannot be blank") String userAnswer) {
		super();
		this.userAnswer = userAnswer;
	}
	public Answer(@NotNull @Size(min = 2, max = 200, message = "Answer cannot be blank") String userAnswer,
			Question question) {
		super();
		this.userAnswer = userAnswer;
		this.question = question;
	}
	public Answer(Long id, @NotNull @Size(min = 2, max = 200, message = "Answer cannot be blank") String userAnswer,
			Date createdAt, Date updatedAt, Question question) {
		super();
		this.id = id;
		this.userAnswer = userAnswer;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.question = question;
	}
	public Answer() {
		super();
	}
    
    // GETTERS / SETTERS
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	public String getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
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

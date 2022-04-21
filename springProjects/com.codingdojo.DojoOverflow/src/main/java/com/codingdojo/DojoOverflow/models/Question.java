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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="question")
public class Question {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Size(min=2,max=200,message="Question cannot be empty")
	private String quest;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // =========== RELATIONSHIPS ===========
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "questions_tags", 
        joinColumns = @JoinColumn(name = "question_id"), 
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tag;
    
    @OneToMany(mappedBy="question", fetch = FetchType.LAZY)
    private List<Answer> answers;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    // =========== CONSTRUCTORS ===========
    public Question() {
		super();
	}
	public Question(Long id, @NotNull @Size(min = 2, max = 200, message = "Question cannot be empty") String quest,
			Date createdAt, Date updatedAt, List<Tag> tag, List<Answer> answers, User user) {
		super();
		this.id = id;
		this.quest = quest;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.tag = tag;
		this.answers = answers;
		this.user = user;
	}
	public Question(@NotNull @Size(min = 2, max = 200, message = "Question cannot be empty") String quest,
			List<Tag> tag, List<Answer> answers, User user) {
		super();
		this.quest = quest;
		this.tag = tag;
		this.answers = answers;
		this.user = user;
	}
	public Question(@NotNull @Size(min = 2, max = 200, message = "Question cannot be empty") String quest) {
		super();
		this.quest = quest;
	}
	
    public Question(@NotNull @Size(min = 2, max = 200, message = "Question cannot be empty") String quest,
			User user) {
		super();
		this.quest = quest;
		this.user = user;
	}
	public Question(@NotNull @Size(min = 2, max = 200, message = "Question cannot be empty") String quest,
			List<Tag> tag, User user) {
		super();
		this.quest = quest;
		this.tag = tag;
		this.user = user;
	}
    
	public Question(@NotNull @Size(min = 2, max = 200, message = "Question cannot be empty") String quest,
			List<Tag> tag) {
		super();
		this.quest = quest;
		this.tag = tag;
	}
	
	// =========== GETTERS / SETTERS ===========
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuest() {
		return quest;
	}
	public void setQuest(String quest) {
		this.quest = quest;
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
	public List<Tag> getTag() {
		return tag;
	}
	public void setTag(List<Tag> tag) {
		this.tag = tag;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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

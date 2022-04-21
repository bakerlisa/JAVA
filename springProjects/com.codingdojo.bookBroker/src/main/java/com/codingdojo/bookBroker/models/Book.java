package com.codingdojo.bookBroker.models;

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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="book")
public class Book {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Size(min=2,max=100,message="Title cannot be blank")
	private String title;
	
	@NotNull
	@Size(min=2,max=100,message="Author cannot be blank")
	private String author;
	
	@NotNull
	@Size(min=2,max=200,message="review cannot be blank")
	private String review;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // ========================= RELATIPNSHIPS =========================
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "borrow", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<User> borrowers;
    	
    // ========================= CONSTRUCTORS =========================
    public Book() {
		super();
	}
	public Book(Long id, @NotNull @Size(min = 2, max = 100, message = "Title cannot be blank") String title,
			@NotNull @Size(min = 2, max = 100, message = "Author cannot be blank") String author,
			@NotNull @Size(min = 2, max = 200, message = "review cannot be blank") String review, Date createdAt,
			Date updatedAt, User user) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.review = review;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
	}
	public Book(@NotNull @Size(min = 2, max = 100, message = "Title cannot be blank") String title,
			@NotNull @Size(min = 2, max = 100, message = "Author cannot be blank") String author,
			@NotNull @Size(min = 2, max = 200, message = "review cannot be blank") String review, User user) {
		super();
		this.title = title;
		this.author = author;
		this.review = review;
		this.user = user;
	}
	public Book(@NotNull @Size(min = 2, max = 100, message = "Title cannot be blank") String title,
			@NotNull @Size(min = 2, max = 100, message = "Author cannot be blank") String author,
			@NotNull @Size(min = 2, max = 200, message = "review cannot be blank") String review) {
		super();
		this.title = title;
		this.author = author;
		this.review = review;
	}
    
    // ========================= GETTERS / SETTERS =========================
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
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

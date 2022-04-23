package com.codingdojo.exam.models;

import java.util.Date;
import java.util.Locale.Category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="votes")
public class Vote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 
	// ================================ RELATIONSHIPS ================================
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="name_id")
	 private Name name;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="user_id")
	 private User user;


	 // ================================ CONSTRUCTORS ================================
	 public Vote() {
		 	super();
	 }

		public Vote(Long id, Date createdAt, Date updatedAt, Name name, User user) {
			super();
			this.id = id;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.name = name;
			this.user = user;
		}

		public Vote(Name name, User user) {
			super();
			this.name = name;
			this.user = user;
		}
		
		// ================================ GETTERS / SETTERS ================================
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

		public Name getName() {
			return name;
		}

		public void setName(Name name) {
			this.name = name;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		
		
}





 
 



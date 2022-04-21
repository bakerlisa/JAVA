package com.codingdojo.StudentRosterMM.models;

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

@Entity
@Table(name="studentCourse")
public class StudentCourse {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	  @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	
	    // =========== RELATIONSHIPS ===========
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="student_id")
	    private Student student;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="course_id")
	    private Course course;
	    
	    // =========== CONSTRUCTORS ===========
	    public StudentCourse() {
			super();
		}

		public StudentCourse(Long id, Date createdAt, Date updatedAt, Student student, Course course) {
			super();
			this.id = id;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.student = student;
			this.course = course;
		}

		public StudentCourse(Student student, Course course) {
			super();
			this.student = student;
			this.course = course;
		}

		// =========== GETTERS / SETTERS ===========
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

		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

		public Course getCourse() {
			return course;
		}

		public void setCourse(Course course) {
			this.course = course;
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

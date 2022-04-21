package com.codingdojo.StudentRosterMM.models;

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
@Table(name="course")
public class Course {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Size(min=2,max=50,message="Subject cannot be blank")
	private String subject;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	// =========== RELATIONSHIPS ===========
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "studentCourse", 
        joinColumns = @JoinColumn(name = "course_id"), 
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;
    
    // =========== CONSTRUCTORS ===========
    public Course() {
		super();
	}
	public Course(Long id, @NotNull @Size(min = 2, max = 50, message = "Subject cannot be blank") String subject,
			Date createdAt, Date updatedAt, List<Student> students) {
		super();
		this.id = id;
		this.subject = subject;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.students = students;
	}
	public Course(@NotNull @Size(min = 2, max = 50, message = "Subject cannot be blank") String subject,
			List<Student> students) {
		super();
		this.subject = subject;
		this.students = students;
	}
	public Course(@NotNull @Size(min = 2, max = 50, message = "Subject cannot be blank") String subject) {
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

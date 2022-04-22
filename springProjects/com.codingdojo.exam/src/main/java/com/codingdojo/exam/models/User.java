package com.codingdojo.exam.models;

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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="user")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty
	@Size(min=2,message="Name cannot be blank")
	private String fullName;
	
	@NotEmpty
	@Email(message="Email cannot be blank")
	private String email;
	
	@NotEmpty
	@Size(min=8,max=128,message="password needs to be between 8-128 characters")
	private String password;
	
	@Transient
	@NotEmpty
	@Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
	private String confirm;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
    // ================================ RELATIPNSHIPS ================================
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Name> names;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "votes", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "name_id")
    )
    private List<Name> votes;

    // ================================ CONSTRUCTORS ================================
    public User() {
		super();
    }

	 public User(@NotEmpty @Size(min = 2, message = "Name cannot be blank") String fullName,
			@NotEmpty @Email(message = "Email cannot be blank") String email,
			@NotEmpty @Size(min = 8, max = 128, message = "password needs to be between 8-128 characters") String password,
			@NotEmpty @Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters") String confirm,
			List<Name> votes) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
		this.votes = votes;
	}



	public User(@NotEmpty @Size(min = 2, message = "Name cannot be blank") String fullName,
			@NotEmpty @Email(message = "Email cannot be blank") String email,
			@NotEmpty @Size(min = 8, max = 128, message = "password needs to be between 8-128 characters") String password,
			@NotEmpty @Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters") String confirm) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
	}
	public User(Long id, @NotEmpty @Size(min = 2, message = "Name cannot be blank") String fullName,
			@NotEmpty @Email(message = "Email cannot be blank") String email,
			@NotEmpty @Size(min = 8, max = 128, message = "password needs to be between 8-128 characters") String password,
			@NotEmpty @Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters") String confirm,
			Date createdAt, Date updatedAt, List<Name> names, List<Name> votes) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.names = names;
		this.votes = votes;
	}


	// ================================ GETTERS / SETTERS ================================
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
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

	public List<Name> getNames() {
		return names;
	}

	public void setNames(List<Name> names) {
		this.names = names;
	}

	public List<Name> getVotes() {
		return votes;
	}

	public void setVotes(List<Name> votes) {
		this.votes = votes;
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


package com.codingdojo.project.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="budget")
public class Budget {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Size(min=2,max=100,message="Name cannot be blank")
	private String name;
	
	@NotNull(message="You must input an income")
	private double income;
	
	private String tag;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // ================================ RELATIPNSHIPS ================================
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    @OneToMany(mappedBy="budget", fetch = FetchType.LAZY)
    private List<Expense> expenses;
    
    @OneToMany(mappedBy="budget", fetch = FetchType.LAZY)
    private List<Temporary> temps;

    // ================================ CONSTRUCTORS ================================
    public Budget() {
		super();
	}

	public Budget(@NotNull @Size(min = 2, max = 100, message = "Name cannot be blank") String name,
			@NotNull(message = "You must input an income") double income, String tag) {
		super();
		this.name = name;
		this.income = income;
		this.tag = tag;
	}



	public Budget(@NotNull @Size(min = 2, max = 100, message = "Name cannot be blank") String name,
			@NotNull(message = "You must input an income") double income, String tag, User user, List<Expense> expenses,
			List<Temporary> temps) {
		super();
		this.name = name;
		this.income = income;
		this.tag = tag;
		this.user = user;
		this.expenses = expenses;
		this.temps = temps;
	}



	public Budget(Long id, @NotNull @Size(min = 2, max = 100, message = "Name cannot be blank") String name,
			@NotNull(message = "You must input an income") double income, String tag, Date createdAt, Date updatedAt,
			User user, List<Expense> expenses, List<Temporary> temps) {
		super();
		this.id = id;
		this.name = name;
		this.income = income;
		this.tag = tag;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
		this.expenses = expenses;
		this.temps = temps;
	}



	// ================================ GETTERS / SETTERS ================================
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
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
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
	public List<Expense> getExpenses() {
		return expenses;
	}
	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}
	public List<Temporary> getTemps() {
		return temps;
	}

	public void setTemps(List<Temporary> temps) {
		this.temps = temps;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	

	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

}
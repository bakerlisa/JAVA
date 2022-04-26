package com.codingdojo.project.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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
	
	private double total;
	
	@NotEmpty(message="You must input an income")
	private double income;
	
	private HashMap<String, Double> expense;
	
	private ArrayList<String> expenseType;
	
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // ================================ RELATIPNSHIPS ================================
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    // ================================ CONSTRUCTORS ================================
    public Budget() {
		super();
	}
    public Budget(Long id, @NotNull @Size(min = 2, max = 100, message = "Name cannot be blank") String name,
			double total, @NotEmpty(message = "You must input an income") double income,
			HashMap<String, Double> expense, ArrayList<String> expenseType, Date createdAt, Date updatedAt, User user) {
		super();
		this.id = id;
		this.name = name;
		this.total = total;
		this.income = income;
		this.expense = expense;
		this.expenseType = expenseType;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
	}

	public Budget(@NotNull @Size(min = 2, max = 100, message = "Name cannot be blank") String name, double total,
			@NotEmpty(message = "You must input an income") double income, HashMap<String, Double> expense,
			ArrayList<String> expenseType, User user) {
		super();
		this.name = name;
		this.total = total;
		this.income = income;
		this.expense = expense;
		this.expenseType = expenseType;
		this.user = user;
	}

	public Budget(@NotNull @Size(min = 2, max = 100, message = "Name cannot be blank") String name, double total,
			@NotEmpty(message = "You must input an income") double income, HashMap<String, Double> expense,
			ArrayList<String> expenseType) {
		super();
		this.name = name;
		this.total = total;
		this.income = income;
		this.expense = expense;
		this.expenseType = expenseType;
	}
    
    // ================================ GETTERS / SETTERS ================================
	
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
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
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public HashMap<String, Double> getExpense() {
		return expense;
	}
	public void setExpense(HashMap<String, Double> expense) {
		this.expense = expense;
	}
	public ArrayList<String> getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(ArrayList<String> expenseType) {
		this.expenseType = expenseType;
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

	
	
	

}

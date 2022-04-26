package com.codingdojo.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.project.models.Expense;
import com.codingdojo.project.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expRepo;
	
	public ExpenseService(ExpenseRepository expRepo) {
		this.expRepo = expRepo;
	}
	
	public List<Expense> allExpenses(){
		return expRepo.findAll();
	}
	
	public Expense createExpense(Expense expense) {
		return expRepo.save(expense);
	}
}

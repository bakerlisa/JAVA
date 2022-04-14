package com.codingdojo.safeTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.safeTravels.models.Expense;
import com.codingdojo.safeTravels.repositories.expenseRepositories;

public class expenseServices {
private final expenseRepositories ExpenseRepositories;
    
    public expenseServices(expenseRepositories ExpenseRepositories) {
        this.ExpenseRepositories = ExpenseRepositories;
    }
    // returns all the expense
    public List<Expense> allExpenses() {
        return ExpenseRepositories.findAll();
    }
    // creates a expense
    public Expense createExpense(Expense expense) {
        return ExpenseRepositories.save(expense);
    }
    // retrieves a expense
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = ExpenseRepositories.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
    
    public void deleteExpense(Long id) {
    	ExpenseRepositories.deleteById(id);
    }
    
    public Expense updateExpense(Long id, String title, String desc, String vendor, double amount) {
    	Optional<Expense> optionalExpense = ExpenseRepositories.findById(id);
    	
    	if(optionalExpense.isPresent()) {
    		
    		Expense thisExpense = optionalExpense.get();
            
    		thisExpense.setTitle(title);
    		thisExpense.setDescription(desc);
    		thisExpense.setVendor(vendor);
    		thisExpense.setAmount(amount);
            
            return ExpenseRepositories.save(thisExpense);
        } else {
            return null;
        }
    }
}

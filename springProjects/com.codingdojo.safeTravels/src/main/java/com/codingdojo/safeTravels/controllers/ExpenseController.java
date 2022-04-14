package com.codingdojo.safeTravels.controllers;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.safeTravels.models.Expense;
import com.codingdojo.safeTravels.services.expenseServices;


@Controller
public class ExpenseController {
	
	@Autowired
	expenseServices ExpenseServices;
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/expense/{expenseId}")
	public String singlExpense(Model model, @PathVariable("expenseId") Long expenseId) {
		Expense expense = ExpenseServices.findExpense(expenseId);
		model.addAttribute("expense",expense);
		return "show.jsp";
	}
	
	@RequestMapping("/expenses")
	public String allExpenses(Model model) {
		List<Expense> expenses = ExpenseServices.allExpenses();
		model.addAttribute("expenses", expenses);
		return "allExpenses.jsp";
	}
	
	@GetMapping("/expense/create")
	public String expense( @ModelAttribute("expense") Expense expense) {
		return "create.jsp";
	}
	
	@PostMapping("/api/expense")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result ) {
		if(result.hasErrors()) {
			return "create.jsp";
		}else {
			ExpenseServices.createExpense(expense);
		}
		return "redirect:/expenses";
	}

}

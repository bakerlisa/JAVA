package com.codingdojo.safeTravels.controllers;
import com.codingdojo.safeTravels.models.Expense;
import com.codingdojo.safeTravels.services.ExpenseServices;

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



@Controller
public class ExpenseController {
	
	@Autowired
	ExpenseServices expenseServices;
	
	@GetMapping("/expenses")
	public String index(Model model, @ModelAttribute("expense") Expense expense) {
		List<Expense> expenses = expenseServices.allExpenses();
		model.addAttribute("expenses", expenses);
		System.out.println(expenses);
		return "index.jsp";
	}
	
	@PostMapping("/api/create")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result ) {
		if(result.hasErrors()) {
			return "index.jsp";
		}else {
			expenseServices.createExpense(expense);
		}
		return "redirect:/expenses";
	}
	
	@GetMapping("/expense")
	public String expense() {
		return "show.jsp";
	}
	
//	@RequestMapping("/expense/{expenseId}")
//	public String singlExpense(Model model, @PathVariable("expenseId") Long expenseId) {
//		Expense expense = expenseServices.findExpense(expenseId);
//		model.addAttribute("expense",expense);
//		return "show.jsp";
//	}
//	
//

}

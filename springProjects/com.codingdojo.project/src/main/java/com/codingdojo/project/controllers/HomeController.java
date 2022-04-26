package com.codingdojo.project.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.project.models.Budget;
import com.codingdojo.project.models.Expense;
import com.codingdojo.project.models.LoginUser;
import com.codingdojo.project.models.Temporary;
import com.codingdojo.project.models.User;
import com.codingdojo.project.services.BudgetService;
import com.codingdojo.project.services.ExpenseService;
import com.codingdojo.project.services.TemporaryService;
import com.codingdojo.project.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private final UserService userSer;
	private final BudgetService budSer;
	private final ExpenseService expSer;
	private final TemporaryService tempSer;
	
	public HomeController(UserService userSer, BudgetService budSer,ExpenseService expSer,TemporaryService tempSer){
		super();
		this.userSer = userSer;
		this.budSer = budSer;
		this.expSer = expSer;
		this.tempSer = tempSer;
	}
	
	// ================================ GENERAL ================================
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if(session.getAttribute("user_id") != null ) {
			return "dashboard.jsp";
		}else {
			model.addAttribute("newUser", new User());
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
			}	
		}
			
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if(session.getAttribute("user_id") != null ) {
			Long loggedID = (Long) session.getAttribute("user_id");
			User userName = userSer.oneUser(loggedID);
			Budget budget = budSer.oneBudget(loggedID);
			model.addAttribute("logged",userName);
			model.addAttribute("budget",budget);
				return "dashboard.jsp";
			}else {
				return "redirect:/";
			}
		}
	
	// ================================ LOGIN / REGISTRATION ================================
	@PostMapping("/api/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,BindingResult result, Model model, HttpSession session) {					
		userSer.register(newUser, result);	
		if(result.hasErrors()) {
			String register = "active";
			model.addAttribute("register",register);
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}			
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/dashboard";
	}
						
	@PostMapping("/api/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user = userSer.login(newLogin, result);
		if(result.hasErrors()) {
			String login = "active";
			model.addAttribute("login",login);
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}				
		session.setAttribute("user_id", user.getId());
		return "redirect:/dashboard";
	}
	
	@GetMapping("/logout")
	public String dashboard(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
		
	// ================================ SETTINGS ===============================
	
	@GetMapping("/settings")
	public String settings() {
		return "settings.jsp";
	}
	
	// ================================ budget ===============================
	@GetMapping("/new/smuget")
	public String newSmuget(Model model, @ModelAttribute("budget") Budget budget,HttpSession session) {
		Long loggedID = (Long) session.getAttribute("user_id");
		User userName = userSer.oneUser(loggedID);
		model.addAttribute("userName",userName);
		return "newSmuget.jsp";
	}
	@GetMapping("/api/add/budget")
	public String addBudget(Model model, @Valid @ModelAttribute("budget") Budget budget) {
		return "redirect:/dashboard";
	}
	
	@PostMapping("/api/add/budget")
	public String addBudgetForm(Model model, @Valid @ModelAttribute("budget") Budget budget, BindingResult result) {
		if(result.hasErrors()) {
			return "newSmuget.jsp";
		}else {
			Budget bud = budSer.createBudget(budget);
			return "redirect:/expense/"+bud.getId(); 
		}
	}
	
	@GetMapping("/expense/{budID}")
	public String addExpense(Model model,@PathVariable("budID") Long budID,@ModelAttribute("expense") Expense expense) {
		model.addAttribute("budget",budSer.oneBudget(budID));
		return "addExpense.jsp";
	}
	
	@PostMapping("/api/add/expense/{budID}")
	public String addExpenseForm(Model model,@PathVariable("budID") Long budID,@Valid  @ModelAttribute("expense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			Budget bud = budSer.oneBudget(budID);
			return "redirect:/expense/"+bud.getId(); 
		}else {
			expSer.createExpense(expense);
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/expense/edit/{budID}")
	public String editBudget(@PathVariable("budID") Long budID) {
		Budget bud = budSer.oneBudget(budID);
		return "editSmuget.jsp";
	}
	
	@GetMapping("/edit/smuget")
	public String editSmuget() {
		return "editSmuget.jsp";
	}
	
	// ================================ Temporary ===============================
	@GetMapping("/temporary/{budID}")
	public String createTemporary(Model model,@PathVariable("budID") Long budID, @ModelAttribute("temporary") Temporary temporary,HttpSession session) {
		Long loggedID = (Long) session.getAttribute("user_id");
		User userName = userSer.oneUser(loggedID);
		Budget budget = budSer.oneBudget(loggedID);
		model.addAttribute("logged",userName);
		model.addAttribute("budget",budget);
		Budget bud = budSer.oneBudget(budID);
		return "newTemporary.jsp";
	}
	
	@PostMapping("/api/add/temporary")
	public String createTemporaryForm(Model model,@Valid  @ModelAttribute("temporary") Temporary temporary,HttpSession session) {
		tempSer.createTemp(temporary);
		return "redirect:/dashboard";
	}
	
	// ================================ History ===============================
	@GetMapping("/history")
	public String history(Model model) {
		return "history.jsp";
	}
}

package com.codingdojo.ProductsCategorys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.ProductsCategorys.models.Category;
import com.codingdojo.ProductsCategorys.models.Product;
import com.codingdojo.ProductsCategorys.services.CategoryService;
import com.codingdojo.ProductsCategorys.services.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private final CategoryService catServ;
	private final ProductService prodserv;
	
	public HomeController(CategoryService catServ,ProductService prodserv) {
		super();
		this.catServ = catServ;
		this.prodserv = prodserv;
	}
	
	// ==================== GENERAL ==================== 
	@GetMapping("/")
	public String index(Model model) {
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		return "dashboard.jsp";
	}
	
	// ==================== Category ==================== 
	@GetMapping("/categories")
	public String categories(Model model) {
		return "categories.jsp";
	}
	
	@GetMapping("/add/category")
	public String addCategory(Model model, @ModelAttribute("category") Category category) {
		return "addCategory.jsp";
	}
	
	@PostMapping("/api/add/category")
	public String addCategoryForm(Model model) {
		return "redirect:/categories";
	}
	
	// ==================== Product ==================== 
	@GetMapping("/products")
	public String products(Model model) {
		return "products.jsp";
	}
	
	@GetMapping("/add/product")
	public String addProduct(Model model, @ModelAttribute("product") Product product) {
		return "addProduct.jsp";
	}
	
	@PostMapping("/api/add/product")
	public String addProductForm(Model model) {
		return "redirect:/products";
	}
	
	
}

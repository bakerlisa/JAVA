package com.codingdojo.productsCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.productsCategories.models.Category;
import com.codingdojo.productsCategories.models.CategoryProduct;
import com.codingdojo.productsCategories.models.Product;
import com.codingdojo.productsCategories.services.CategoryProductService;
import com.codingdojo.productsCategories.services.CategoryService;
import com.codingdojo.productsCategories.services.ProductService;

@Controller
public class HomeController {
	private final CategoryService catSer;
	private final ProductService prodSer;
	private final CategoryProductService catProSer;
	
	public HomeController(CategoryService catSer,ProductService prodSer,CategoryProductService catProSer){
		this.catSer = catSer;
		this.prodSer = prodSer;
		this.catProSer = catProSer;
	}
	
	// ================== GENERAL ==================
	@GetMapping("/")
	public String index(Model model) {
		return "index.jsp";
	}
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		return "dashboard.jsp";
	}
	
	// ================== CATEGORY ==================
	@GetMapping("/categorys")
	public String categorys(Model model) {
		List<Category> categories = catSer.allCategorys();
		model.addAttribute("categories",categories);
		return "categories.jsp";
	}
	
	@GetMapping("/add/category")
	public String addCategory(Model model,@ModelAttribute("category") Category category) {
		return "addCategory.jsp";
	}
	
	@PostMapping("/api/add/category")
	public String addCategoryForm(Model model,@Valid @ModelAttribute("category") Category category,BindingResult result) {
		if(result.hasErrors()) {
			return "addCategory.jsp";
		}else {
			catSer.addCategory(category);
			return "redirect:/categorys";
		}
	}
	
	// ================== PRODUCTS ==================
	@GetMapping("/products")
	public String products(Model model) {
		model.addAttribute("products", prodSer.allProducts());
		return "products.jsp";
	}
	@GetMapping("/add/product")
	public String addProduct(Model model,@ModelAttribute("product") Product product) {
		return "addProduct.jsp";
	}
	
	
	
	
	
	@GetMapping("/product/{id}")
	public String singleProduct(Model model, @PathVariable("id") Long id, @ModelAttribute("ProductCategory") CategoryProduct ProductCategory) {
		Product product = prodSer.singleProduct(id);
		List<Category> cats = catSer.findCats(product);	
				
		model.addAttribute("product",product);
		model.addAttribute("cats",cats);
		return "product.jsp";
	}
	
	@GetMapping("/category/{id}")
	public String singleCategory(Model model, @PathVariable("id") Long id, @ModelAttribute("ProductCategory") CategoryProduct ProductCategory) {
		Category category = catSer.singleCategory(id);
		List<Product> product = prodSer.findProds(category);

		model.addAttribute("category",category);
		model.addAttribute("product",product);
		return "category.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping("/api/add/product")
	public String addProductForm(Model model,@Valid @ModelAttribute("product") Product product,BindingResult result) {
		if(result.hasErrors()) {
			return "addProduct.jsp";
		}else {
			prodSer.addProduct(product);
			return "redirect:/products";
		}
	}
	
	// ================== PRODUCTS / CATEGORYS ==================
	
	@PostMapping("/api/categorize")
	public String addToCategory(Model model,@ModelAttribute("ProductCategory") CategoryProduct ProductCategory) {
		catProSer.saveCategory(ProductCategory);
		return "redirect:/categorys";
	}
	
	@PostMapping("/api/productize")
	public String addToProduct(Model model,@ModelAttribute("ProductCategory") CategoryProduct ProductCategory) {
		catProSer.saveCategory(ProductCategory);
		return "redirect:/products";
	}
}

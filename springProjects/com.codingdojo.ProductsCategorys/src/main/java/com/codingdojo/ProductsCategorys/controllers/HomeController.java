package com.codingdojo.ProductsCategorys.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.ProductsCategorys.models.Category;
import com.codingdojo.ProductsCategorys.models.CategoryProduct;
import com.codingdojo.ProductsCategorys.models.Product;
import com.codingdojo.ProductsCategorys.services.CategoryProductService;
import com.codingdojo.ProductsCategorys.services.CategoryService;
import com.codingdojo.ProductsCategorys.services.ProductService;



@Controller
public class HomeController {
	
	@Autowired
	private final CategoryService catServ;
	private final ProductService prodServ;
	private final CategoryProductService catProdServ;
	
	public HomeController(CategoryService catServ,ProductService prodServ,CategoryProductService catProdServ) {
		super();
		this.catServ = catServ;
		this.prodServ = prodServ;
		this.catProdServ = catProdServ;
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
		List<Category> categories = catServ.allCategorys();
		model.addAttribute("categories", categories);
		return "categories.jsp";
	}
	
	@GetMapping("/category/{id}")
	public String singleCategory(Model model, @PathVariable("id") Long id, @ModelAttribute("categoryProduct") CategoryProduct categoryProduct ) {
		Category category = catServ.singleCategory(id);
		List<Product> products = prodServ.allProducts();
		
		model.addAttribute("products",products);
		model.addAttribute("category",category);
		System.out.println(category.getProducts().getClass().getSimpleName());
		for(Product in category.getProducts()) {
			Product.
		}
		
//		System.out.println(category.getClass().getSimpleName() );
		return "category.jsp";
	}
	
	@GetMapping("/add/category")
	public String addCategory(Model model, @ModelAttribute("category") Category category) {
		List<Product> products = prodServ.allProducts();
		model.addAttribute("products", products);
		return "addCategory.jsp";
	}
	
	@PostMapping("/api/add/category")
	public String addCategoryForm(Model model, @Valid @ModelAttribute("category") Category category,BindingResult result) {
		if(result.hasErrors()) {
			return "addCategory.jsp";
		}else {
			catServ.addCategoryForm(category);
			return "redirect:/categories";
		}
	}
	
	// ==================== Product ==================== 
	@GetMapping("/products")
	public String products(Model model) {
		List<Product> products = prodServ.allProducts();
		model.addAttribute("products", products);
		return "products.jsp";
	}
	
	@GetMapping("/product")
	public String product(Model model,@PathVariable("id") Long id) {
		Product product = prodServ.singleProduct(id);
		model.addAttribute("product", product);
		return "products.jsp";
	}
	
	@GetMapping("/add/product")
	public String addProduct(Model model, @ModelAttribute("product") Product product) {
		return "addProduct.jsp";
	}
	
	@GetMapping("/product/{id}")
	public String addProduct(Model model, @PathVariable("id") Long id) {
		Product product = prodServ.singleProduct(id);
		List<Category> categories = catServ.allCategorys();
		model.addAttribute("product",product);
		model.addAttribute("categories",categories);
		return "product.jsp";
	}
	
	@PostMapping("/api/add/product")
	public String addProductForm(Model model, @Valid  @ModelAttribute("product") Product product, BindingResult result ) {
		if(result.hasErrors()) {
			return "addProduct.jsp";
		}else {
			prodServ.addProduct(product);
			return "redirect:/products";
		}
	}
	
	// ==================== Product / Category ==================== 	
	@PostMapping("/api/product/category")
	public String addProductToCategoryForm(Model model, @ModelAttribute("categoryProduct") CategoryProduct categoryProduct ) {
		
		catProdServ.addProductCategory(categoryProduct);
		
		
		return "redirect:/categories";
	}
	
}

package com.codingdojo.productsCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.productsCategories.models.Category;
import com.codingdojo.productsCategories.models.Product;
import com.codingdojo.productsCategories.repositories.CategoryRepository;
import com.codingdojo.productsCategories.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository prodRepo;
	
	public ProductService(ProductRepository prodRepo) {
		this.prodRepo = prodRepo;
	}
	
	public List<Product> allProducts(){
		return prodRepo.findAll();
	}
	
	public Product addProduct(Product product) {
		return prodRepo.save(product);
	}
	
	public Product singleProduct(Long id) {
		Optional<Product> optPro = prodRepo.findById(id);;
		if(optPro.isPresent()) {
			return optPro.get();
		}else {
			return null;
		}
	}
	
	public List<Product> findProds(Category category){
		return prodRepo.findByCategoriesNotContains(category);
	}
	

	
}

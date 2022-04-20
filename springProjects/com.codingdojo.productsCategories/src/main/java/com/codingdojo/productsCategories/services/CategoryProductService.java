package com.codingdojo.productsCategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.productsCategories.models.CategoryProduct;
import com.codingdojo.productsCategories.models.Product;
import com.codingdojo.productsCategories.repositories.CategoryProductRepository;

@Service
public class CategoryProductService {
	private final CategoryProductRepository catProRepo;
	
	public CategoryProductService(CategoryProductRepository catProRepo){
		this.catProRepo = catProRepo;
	}
	
	public List<Product> allProducts(Long id){
		return catProRepo.findProductsNotIn(id);
	}
	
	public CategoryProduct addProducttoCat(CategoryProduct cateProd) {
		return catProRepo.save(cateProd);
	}
	
	public CategoryProduct saveCategory(CategoryProduct cateProd) {
		return catProRepo.save(cateProd);
	}
}

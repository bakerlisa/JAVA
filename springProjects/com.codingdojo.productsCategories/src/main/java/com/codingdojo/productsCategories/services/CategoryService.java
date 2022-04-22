package com.codingdojo.productsCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.productsCategories.models.Category;
import com.codingdojo.productsCategories.models.Product;
import com.codingdojo.productsCategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	private CategoryRepository catRepo;
	
	public CategoryService(CategoryRepository catRepo){
		this.catRepo = catRepo;
	}
	
	public List<Category> allCategorys(){
		return catRepo.findAll();
	}
	
	public Category addCategory(Category category) {
		return catRepo.save(category);
	}
	
	public Category singleCategory(Long id) {
		Optional<Category> optCat = catRepo.findById(id);
		if(optCat.isPresent()) {
			return optCat.get();
		}else {
			return null;
		}
	}
	
	public List<Category> findCats(Product product){
		return catRepo.findByProductsNotContains(product);
	}
	
	public int test(){ return (int) catRepo.count(); }

}

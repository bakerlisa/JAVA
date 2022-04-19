package com.codingdojo.ProductsCategorys.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.ProductsCategorys.models.Category;
import com.codingdojo.ProductsCategorys.models.CategoryProduct;
import com.codingdojo.ProductsCategorys.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository catRepo;
	
	public CategoryService(CategoryRepository catRepo) {
		this.catRepo = catRepo;
	}
	
	public List<Category> allCategorys(){
		return catRepo.findAll();
	}
	
	public Category addCategoryForm(Category category) {
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
	
//	public Category updateProduct(Category category) {
//		Optional<Category> optCat = catRepo.findById(category.getId());
//		if(optCat.isPresent()) {
//			Category thisCat = optCat.get();
//			
//			thisCat.setName(category.getName());
//			thisCat.setId(Integer.parseInt(category.getId()));
////			thisCat.add(category.getProducts());
//			
//			return optCat.get();
//		}else {
//			return null;
//		}
//	}
	
}

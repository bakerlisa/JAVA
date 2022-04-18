package com.codingdojo.ProductsCategorys.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.ProductsCategorys.models.Category;
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
}

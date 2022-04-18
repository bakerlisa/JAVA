package com.codingdojo.ProductsCategorys.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.ProductsCategorys.models.CategoryProduct;
import com.codingdojo.ProductsCategorys.repositories.CategoryProductRepository;

@Service
public class CategoryProductService {
	private final CategoryProductRepository catProdRepo;

	
	public CategoryProductService(CategoryProductRepository catProdRepo) {
		this.catProdRepo = catProdRepo;
	}
	
	public CategoryProduct addProductCategory (CategoryProduct newCatProd) {
		return catProdRepo.save(newCatProd);
	}
	
	public List<CategoryProduct> getProductsOfCategory(Long id) {
		return catProdRepo.findAllProductByCategoryId(id);
	}
	
	
}

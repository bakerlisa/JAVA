package com.codingdojo.ProductsCategorys.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.ProductsCategorys.models.Category;
import com.codingdojo.ProductsCategorys.models.Product;
import com.codingdojo.ProductsCategorys.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository prodRepo;
	
	public ProductService(ProductRepository prodRepo) {
		this.prodRepo = prodRepo;
	}
	
	public List<Product> allProducts(){
		return prodRepo.findAll();
	}
	
	public Product singleProduct(Long id) {
		Optional<Product> optProd = prodRepo.findById(id);
		if(optProd.isPresent()) {
			return optProd.get();
		}else {
			return null;
		}
	}
	
	public Product addProduct(Product product) {
		return prodRepo.save(product);
	}
}

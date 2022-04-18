package com.codingdojo.ProductsCategorys.services;

import java.util.List;

import org.springframework.stereotype.Service;

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
}

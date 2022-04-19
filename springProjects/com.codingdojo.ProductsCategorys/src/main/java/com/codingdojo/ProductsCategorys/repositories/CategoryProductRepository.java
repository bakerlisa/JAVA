package com.codingdojo.ProductsCategorys.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ProductsCategorys.models.Category;
import com.codingdojo.ProductsCategorys.models.CategoryProduct;
import com.codingdojo.ProductsCategorys.models.Product;

@Repository
public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long>{
	List<CategoryProduct> findAll();
	
	List<CategoryProduct> findAllProductIdByCategoryId(Long id);
}

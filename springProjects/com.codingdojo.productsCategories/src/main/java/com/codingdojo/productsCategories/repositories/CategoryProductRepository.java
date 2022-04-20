package com.codingdojo.productsCategories.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.productsCategories.models.Category;
import com.codingdojo.productsCategories.models.CategoryProduct;
import com.codingdojo.productsCategories.models.Product;

@Repository
public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {
	List<CategoryProduct> findAll();
	
//	List<CategoryProduct> findAllProductIdByCategoryId(Long id);	

	@Query(value = "SELECT * FROM product LEFT JOIN categories_products ON product.id = categories_products.product_id WHERE product.id != ?1", nativeQuery = true)
	List<Product> findProductsNotIn(Long id);
}

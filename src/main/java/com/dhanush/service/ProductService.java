package com.dhanush.service;

import java.util.List;

import com.dhanush.entity.Product;

public interface ProductService {
	Product saveProduct(Product product);

	Product updateProduct(Product product);

	void deleteProduct(Long productId);

	Long numberOfProducts();

	List<Product> findAllProducts();
}

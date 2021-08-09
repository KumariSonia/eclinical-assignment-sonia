package com.ecw.services;

import java.util.List;

import com.ecw.model.Product;

public interface ProductService {

	/*
	 * Method 1: This Method Used To Create A New Product Record In The Database
	 * Table
	 */
	public void createProduct(Product product);

	/*
	 * Method 2: This Method Is Used To Delete A Particular Record From The Database
	 * Table
	 */
	public void deleteProduct(int productId);

	/*
	 * Method 3: This Method Is Used To Display The Records From The Database Table
	 */
	public List<Product> getProductsDetail();

	/* Method 4: This Method To Find Particular Record In The Database Table */
	public Product getProductById(int productId);

	public void updateProduct(Product product);

	/*
	 * Method 5: This Method Is Used To Delete All Records From The Database Table
	 */
	public void deleteAllRecords();
}

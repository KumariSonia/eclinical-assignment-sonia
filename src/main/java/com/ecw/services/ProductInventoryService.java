package com.ecw.services;

import com.ecw.model.ProductType;

public interface ProductInventoryService {

	public void addStock(ProductType product, int quantity); 
	public void reduceStock(ProductType product, int quantity);
	
}

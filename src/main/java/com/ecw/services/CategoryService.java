package com.ecw.services;

import java.util.List;

import com.ecw.model.Category;

public interface CategoryService {
	public void createCategory(Category catogory);

	public void deleteCategory(int categoryId);

	public List<Category> getCategoriesDetail();

	public Category getCategoryById(int categoryId);

	public void updateCategory(Category catogory);
}

package com.cg.bookstore.service;

import java.util.List;
import com.cg.bookstore.entity.Category;
import com.cg.bookstore.exception.EmptyCategoryListException;

public interface ICategoryService {
	
	public Category createCategory(Category categoryName);
	public Category editCategory(Category categoryName); 
	public void deleteCategory(long categoryId);
	public List<Category> categoryList() throws EmptyCategoryListException;

}

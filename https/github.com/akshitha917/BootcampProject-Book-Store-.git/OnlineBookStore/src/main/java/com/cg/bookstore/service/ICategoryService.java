package com.cg.bookstore.service;

import java.util.List;
import com.cg.bookstore.entity.Category;
import com.cg.bookstore.exception.InputInvalidException;

public interface ICategoryService {
	
	public Category createCategory(Category category);
	public Category editCategory(Category category); 
	public void deleteCategory(long categoryId) throws InputInvalidException ;
	public List<Category> categoryList();

}
package com.cg.bookstore.service;

import java.util.List;
import java.util.Random;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookstore.entity.Category;
import com.cg.bookstore.exception.EmptyCategoryListException;
import com.cg.bookstore.repository.CategoryRepository;

@Service
@Transactional
public class CategoryService implements ICategoryService {
	
	@Autowired
	CategoryRepository categoryRepo;

	public Category createCategory(Category category) {
		// TODO Auto-generated method stub
		category.setCategoryId(Long.parseLong(String.valueOf(Math.abs(new Random().nextLong())).substring(0, 1)));
		return categoryRepo.save(category);
	}

	@Override
	public Category editCategory(Category categoryName) {
		// TODO Auto-generated method stub
		return categoryRepo.save(categoryName);
	}


	@Override
	public void deleteCategory(long categoryId) {
		// TODO Auto-generated method stub
		if(categoryRepo.existsById(categoryId)) {
			categoryRepo.deleteById(categoryId);
		}		
	}

	@Override
	public List<Category> categoryList() throws EmptyCategoryListException {
		if(categoryRepo.count()==0)
			throw new EmptyCategoryListException("Empty category list");
		return categoryRepo.findAll();
	}
}

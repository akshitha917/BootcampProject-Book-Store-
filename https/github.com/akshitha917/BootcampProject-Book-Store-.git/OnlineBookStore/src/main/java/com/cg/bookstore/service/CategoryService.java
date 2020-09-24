package com.cg.bookstore.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookstore.entity.Category;
import com.cg.bookstore.exception.InputInvalidException;
import com.cg.bookstore.repository.CategoryRepository;

@Service
@Transactional
public class CategoryService implements ICategoryService {
	
	@Autowired
	CategoryRepository categoryRepo;

	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category editCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public void deleteCategory(long categoryId) throws InputInvalidException {
		
		if(categoryRepo.existsById(categoryId)) {
			categoryRepo.deleteById(categoryId);
		}
		else
			 throw new InputInvalidException("Customer with Id "+categoryId+" Not Found");
	}

	@Override
	public List<Category> categoryList() {
		return categoryRepo.findAll();
	}

}

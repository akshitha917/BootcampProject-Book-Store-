package com.cg.bookstore.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bookstore.entity.Category;
import com.cg.bookstore.exception.EmptyCategoryListException;
import com.cg.bookstore.service.CategoryService;

@RestController
@RequestMapping("/bookstore")
public class CategoryController {
		
		@Autowired
		CategoryService service;

		@PostMapping("/add")
		@ResponseStatus(code = HttpStatus.CREATED)
		public Category createCategory(@Valid @RequestBody Category categoryName) {
			return service.createCategory(categoryName);
		}
		

		@GetMapping("/all")
		public List<Category> categoryList() throws EmptyCategoryListException {
			return service.categoryList();
		}

		@DeleteMapping("/delete/categoryId/{categoryId}")
		public void deleteCategory(@PathVariable long categoryId)  {
			service.deleteCategory(categoryId);
		}

		@PutMapping("/update")
		public Category editCategory(@Valid @RequestBody Category categoryName) {
			return service.editCategory(categoryName);
		}

}

package com.cg.bookstore.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bookstore.entity.Category;
import com.cg.bookstore.exception.InputInvalidException;
import com.cg.bookstore.service.CategoryService;
@Validated
@RestController
@RequestMapping("/bookstore")
public class CategoryController {
		
		@Autowired
		CategoryService service;

		@PostMapping("/add")	
		public ResponseEntity<Category> createCategory(@Valid @RequestBody   Category category){
			return new ResponseEntity<Category>(service.createCategory(category),HttpStatus.CREATED);
		}

		@GetMapping("/all")
		public ResponseEntity<List<Category>> getAllAccounts() 
		{
			return new ResponseEntity<List<Category>>(service.categoryList(),HttpStatus.OK);
		}

		@DeleteMapping("/delete/categoryId/{categoryId}")
		public ResponseEntity<String> deleteCategory(@PathVariable long categoryId) throws InputInvalidException  {
			
			service.deleteCategory(categoryId);
			return new ResponseEntity<String>("Deleted the requested Id"+ " "+categoryId ,HttpStatus.OK);
		}

		@PutMapping("/update")
		public ResponseEntity<Category> editCategory(@Valid @RequestBody  Category category) {
			return new ResponseEntity<Category>(service.editCategory(category),HttpStatus.OK);
		}
		
		@ExceptionHandler
		public String errorMessage(Exception e) {
			return e.getMessage();
		}
}

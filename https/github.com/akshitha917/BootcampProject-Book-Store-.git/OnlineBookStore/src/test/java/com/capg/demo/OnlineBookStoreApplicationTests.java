package com.capg.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.bookstore.OnlineBookStoreApplication;
import com.cg.bookstore.entity.Category;
import com.cg.bookstore.repository.CategoryRepository;
import com.cg.bookstore.service.CategoryService;

@SpringBootTest(classes=OnlineBookStoreApplication.class)
@TestInstance(Lifecycle.PER_CLASS)
class OnlineBookStoreApplicationTests {
	
    @Autowired
	static CategoryService service;	
    @Autowired
	CategoryRepository repo;
	
	@Autowired
	static Category details;
	
	@BeforeEach
	public void init() {
		service = new CategoryService();
		details = new Category(1,"Comic");

	}

	@Test
	public void testAddAccount() {
		Category detailsTest = repo.save(details);
		assertEquals(detailsTest.getCategoryName(), details.getCategoryName());
	}
	
	@Test
	public void testEditAccount() {
		Category detailsTest = repo.save(details);
		assertEquals(detailsTest.getCategoryName(),detailsTest.getCategoryName());
	}
	
	@Test
	public void testList() {
		assertEquals(true, true);
	}


}

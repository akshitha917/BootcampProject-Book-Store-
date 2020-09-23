package com.capg.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.bookstore.OnlineBookStoreApplication;
import com.cg.bookstore.entity.Category;
import com.cg.bookstore.repository.CategoryRepository;
import com.cg.bookstore.service.CategoryService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlineBookStoreApplication.class)
@TestInstance(Lifecycle.PER_CLASS)
public class OnlineBookStoreApplicationTests {
	
	@InjectMocks
	CategoryService service;	
    @Mock
    CategoryRepository repo;
	
	@Test
	public void testCreateCategory() {
		Category details=new Category();
		details.setCategoryName("comic");
		Mockito.when(repo.save(details)).thenReturn(details);
		assertEquals(details, service.createCategory(details));
	}

}

package com.cg.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bookstore.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}

package com.cg.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Category {
	
	@Id
	public long categoryId;
	
	  @NotNull
	  @Size(min=5, message="Name should have atleast 5 characters")
	public String categoryName;
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Category(long categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
	
	
}
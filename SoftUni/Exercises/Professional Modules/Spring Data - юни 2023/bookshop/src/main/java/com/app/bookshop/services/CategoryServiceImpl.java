package com.app.bookshop.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.app.bookshop.models.Category;
import com.app.bookshop.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	private final CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public Set<Category> getRandomCategories() {
		Set<Category> categories = new HashSet<>();
		categories.addAll(categoryRepository.findAll());
		return categories;
	}


}

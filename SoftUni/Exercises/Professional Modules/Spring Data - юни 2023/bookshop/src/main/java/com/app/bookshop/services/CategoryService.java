package com.app.bookshop.services;

import java.util.Set;

import com.app.bookshop.models.Category;

public interface CategoryService {

	public Set<Category> getRandomCategories();
}

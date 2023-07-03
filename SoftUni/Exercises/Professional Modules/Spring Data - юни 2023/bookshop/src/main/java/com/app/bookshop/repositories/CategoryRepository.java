package com.app.bookshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bookshop.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}

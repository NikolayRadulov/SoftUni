package com.app.bookshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bookshop.models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
		
}

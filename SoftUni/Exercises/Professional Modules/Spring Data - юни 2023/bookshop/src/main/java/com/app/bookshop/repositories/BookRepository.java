package com.app.bookshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bookshop.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	

}

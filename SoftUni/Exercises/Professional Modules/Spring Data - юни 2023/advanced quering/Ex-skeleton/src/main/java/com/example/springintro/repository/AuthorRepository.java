package com.example.springintro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springintro.model.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY a.books.size DESC")
    List<Author> findAllByBooksSizeDESC();
    
    @Query("SELECT a FROM Author a WHERE a.firstName like %:suffix")
    List<Author> findByNameSuffix(@Param("suffix") String suffix);
    
    Author findByFirstNameAndLastName(String firstName, String lastName);
}

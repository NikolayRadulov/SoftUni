package com.example.springintro.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);
    
    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);
    
    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal min, BigDecimal max);
    
    @Query("Select b from Book b Where LOWER(b.title) LiKE %:contains%")
    List<Book> findByText(@Param("contains") String contains);
    
    @Query("Select b from Book as b JOIN b.author as a Where a.lastName like :prefix%")
    List<Book> getAllByAuthorName(@Param("prefix") String prefix);
    
    @Query("Select b from Book as b where length(b.title) > :minLength")
    List<Book> getAllByMinLength(int minLength);
    
    List<Book> getAllByAuthor(Author author);
    
    Book getByTitle(String title);
}

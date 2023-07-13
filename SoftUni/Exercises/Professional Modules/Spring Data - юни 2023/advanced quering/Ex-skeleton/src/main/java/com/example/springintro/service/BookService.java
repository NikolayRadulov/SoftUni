package com.example.springintro.service;

import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.Book;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<Book> getBooksByAgeRestriction(String ageRestriction);
    
    List<Book> getAllGoldenBooksWithLessThan5000Copies(String ageRestriction, int copies);
    
    List<Book> getAllBookByPriceRange(BigDecimal min, BigDecimal max);
    
    List<String> findAllByText(String substring);
    
    List<String> findAllByAuthorSubstring(String substring);
    
    int getCountBooksByMinLength(int minLength);
    
    int getTotalCopiesOfAuthor(Author author);
    
    String getInfoOfBook(String title);
}

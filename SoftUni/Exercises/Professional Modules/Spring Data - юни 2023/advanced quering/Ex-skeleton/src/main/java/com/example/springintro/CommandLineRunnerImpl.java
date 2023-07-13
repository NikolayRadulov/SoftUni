package com.example.springintro;

import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        //printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
     //   printAllAuthorsAndNumberOfTheirBooks();
       // pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");
       // printAllBooksThatMatchAgeRestriction("tEeN");
       // printAllGoldenBooksWithLessThan5000copies();
       // printAllBooksWithPriceLowerThan5AndHigherThan40();
       // getAuthorsByName("dy");
       // getBooksByText("WOR");
       // getBooksByAuthorName("Gr");
        //getBooksByLength(12);
        //getTotalCopiesOfAuthor("Randy", "Graham");
        getInfoOfBook("Things fall apart");
    }

    private void getInfoOfBook(String title) {
		System.out.println(bookService.getInfoOfBook(title));
		
	}

	private void getTotalCopiesOfAuthor(String name, String name2) {
		Author author = authorService.getByName(name, name2);
		
		System.out.println(bookService.getTotalCopiesOfAuthor(author));
		
	}

	private void getBooksByLength(int length) {
		System.out.println(bookService.getCountBooksByMinLength(length));
		
	}

	private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
    
    private void printAllBooksThatMatchAgeRestriction(String ageRestriction) {
    	bookService.getBooksByAgeRestriction(ageRestriction.toUpperCase()).forEach(book -> System.out.println(book.getTitle()));
    }
    
    private void printAllGoldenBooksWithLessThan5000copies() {
    	bookService.getAllGoldenBooksWithLessThan5000Copies("GOLD", 5000).forEach(book -> System.out.println(book.getTitle()));
    }
    
    private void printAllBooksWithPriceLowerThan5AndHigherThan40() {
    	bookService.getAllBookByPriceRange(new BigDecimal("5"), new BigDecimal("40")).forEach(book -> System.out.printf("%s -> $%.2f%n", book.getTitle(), book.getPrice()));
    }
    
    private void getAuthorsByName(String suffix) {
    	authorService.getAllAuthoursByNameSuffrix(suffix).forEach(authorName -> System.out.println(authorName));
    }
    private void getBooksByText(String data) {
    	bookService.findAllByText(data).forEach(System.out::println);
    }
    private void getBooksByAuthorName(String subName) {
    	bookService.findAllByAuthorSubstring(subName).forEach(System.out::println);
    }
}

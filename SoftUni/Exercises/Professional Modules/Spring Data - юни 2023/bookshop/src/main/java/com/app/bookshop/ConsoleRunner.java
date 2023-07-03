package com.app.bookshop;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.app.bookshop.models.Author;
import com.app.bookshop.models.Book;
import com.app.bookshop.models.Category;
import com.app.bookshop.models.User;
import com.app.bookshop.models.enums.AgeRestriction;
import com.app.bookshop.models.enums.EditionType;
import com.app.bookshop.repositories.AuthorRepository;
import com.app.bookshop.repositories.BookRepository;
import com.app.bookshop.repositories.CategoryRepository;
import com.app.bookshop.services.AuthorService;
import com.app.bookshop.services.CategoryService;
import com.app.bookshop.services.UserService;

@Component
public class ConsoleRunner implements ProgramRunner {

	
	private final CategoryService categoryService;
	private final AuthorService authorService;
	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;
	private final CategoryRepository categoryRepository;
	private final UserService userService;
	
	public ConsoleRunner(CategoryService categoryService, AuthorService authorService, BookRepository rep, AuthorRepository authorRepository, CategoryRepository categoryRepository, UserService userService) {
		this.authorService = authorService;
		this.categoryService = categoryService;
		this.bookRepository = rep;
		this.authorRepository = authorRepository;
		this.categoryRepository = categoryRepository;
		this.userService = userService;
	}

	@Override
	public void run(String... args) throws Exception {
		seedDatabase();

	}
	
	private void seedDatabase() throws IOException {		
		seedAuthors();
		seedCategories();
		seedBooks();
	}

	@Override
	public void seedAuthors() throws IOException {
		Files.readAllLines(Path.of("C:\\Users\\nikol\\OneDrive\\Desktop\\bookshop\\files\\authors.txt"))
		.forEach(line -> {
			String[] names = line.split("\\s+");
			Author author = new Author(names[0], names[1]);
			authorRepository.saveAndFlush(author);
			
		});
		
	}

	@Override
	public void seedCategories() throws IOException {
		Files.readAllLines(Path.of("C:\\Users\\nikol\\OneDrive\\Desktop\\bookshop\\files\\categories.txt"))
		.forEach(line -> {
			Category category = new Category(line);
			if(!line.equals("")) categoryRepository.saveAndFlush(category);
			
		});
		
	}

	@Override
	public void seedBooks() throws IOException {
		Files.readAllLines(Path.of("C:\\Users\\nikol\\OneDrive\\Desktop\\bookshop\\files\\books.txt"))
		.forEach(file -> {
			String[] data = file.split("\\s+");
			
			EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
			
			 LocalDate releaseDate = LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
			 
			 Author author = authorService.getRandomAuthor();
			 
			 int copies = Integer.parseInt(data[2]);
			 BigDecimal price = new BigDecimal(data[3]);
			 AgeRestriction ageRestriction = AgeRestriction
			 .values()[Integer.parseInt(data[4])];
			 String title = Arrays.stream(data)
			 .skip(5)
			.collect(Collectors.joining(" "));
			 Set<Category> categories = categoryService.getRandomCategories();
			 Book book = new Book(title, editionType, price, releaseDate,
			 ageRestriction, author, categories, copies);
			 bookRepository.saveAndFlush(book);
			
		});
		
	}

	@Override
	public void getUsersByEmailProvider() {
		Scanner sc = new Scanner(System.in);
		String provider = sc.nextLine();
		
		List<User> users = userService.findAllByEmailProvider(provider);
		if(users.isEmpty() || users == null) {
			System.out.println("No users found with email domain " + provider);
			sc.close();
			return;
		}
		for(User user : users) {
			System.out.println(user.toString());
		}
		
		sc.close();
	}

	@Override
	public void removeInactiveUsers() {
		Scanner sc = new Scanner(System.in);
		
		String dateString = sc.nextLine();
		
		LocalDateTime date = LocalDateTime.parse(dateString);
		
		userService.markAllInactiveUsers(date);
		
		sc.close();
	}

}

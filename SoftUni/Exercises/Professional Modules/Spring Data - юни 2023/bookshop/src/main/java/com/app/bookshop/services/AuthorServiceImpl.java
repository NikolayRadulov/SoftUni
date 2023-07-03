package com.app.bookshop.services;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.app.bookshop.models.Author;
import com.app.bookshop.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

	private final AuthorRepository authorRepository;
	
	public AuthorServiceImpl(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public Author getRandomAuthor() {
		List<Author> authors = authorRepository.findAll();
		if(authors == null) return null;
		int random = new Random().nextInt(authors.size());
		
		return authors.get(random);
	}
	
}
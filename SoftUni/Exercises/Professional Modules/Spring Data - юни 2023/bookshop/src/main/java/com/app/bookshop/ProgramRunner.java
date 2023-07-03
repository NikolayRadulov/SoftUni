package com.app.bookshop;

import java.io.IOException;

import org.springframework.boot.CommandLineRunner;

public interface ProgramRunner extends CommandLineRunner {

	void seedAuthors() throws IOException;
	void seedCategories() throws IOException;
	void seedBooks() throws IOException;
	void getUsersByEmailProvider();
	void removeInactiveUsers();
	
}

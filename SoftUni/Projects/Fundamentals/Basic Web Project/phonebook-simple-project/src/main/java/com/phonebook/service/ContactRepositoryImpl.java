package com.phonebook.service;

import com.phonebook.entity.Contact;
import com.phonebook.repository.ContactRepository;

public class ContactRepositoryImpl {

	private final ContactRepository rep;
	
	public ContactRepositoryImpl(ContactRepository rep) {
		this.rep = rep;
	}
	
	public void saveToDB(Contact contact) {
		rep.save(contact);
	}

	
}

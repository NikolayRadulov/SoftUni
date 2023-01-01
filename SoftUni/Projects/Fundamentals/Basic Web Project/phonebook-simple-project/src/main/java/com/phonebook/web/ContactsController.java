package com.phonebook.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.phonebook.entity.Contact;
import com.phonebook.repository.ContactRepository;

@Controller
public class ContactsController {

	private final ContactRepository rep;
	
	public ContactsController(ContactRepository rep) {
		this.rep = rep;
	}	
	
	@GetMapping("/all")
	public String getAllContacts(Model model) {
		model.addAttribute("contacts", rep.findAll());
		return "frontend/index.html";
	}
	@PostMapping("/all")
	public String getAllContacts(Model model, Contact contact) {	
		rep.save(contact);
		model.addAttribute("contacts", rep.findAll());
		return "frontend/index.html";
	}
	@GetMapping("/add")
	public String getAddPage() {		
		return "frontend/newContactPage.html";
	}

}

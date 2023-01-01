package com.phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phonebook.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}

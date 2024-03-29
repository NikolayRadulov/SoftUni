package com.app.bookshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bookshop.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}

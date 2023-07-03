package com.app.bookshop.services;

import java.time.LocalDateTime;
import java.util.List;

import com.app.bookshop.models.User;

public interface UserService {
	List<User> findAllByEmailProvider(String provider);
	
	void markAllInactiveUsers(LocalDateTime dateTime);
	
	void removeAllInactiveUsers(List<User> inactiveUsers);
}

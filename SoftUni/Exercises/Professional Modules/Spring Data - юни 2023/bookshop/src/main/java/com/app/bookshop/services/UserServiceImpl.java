package com.app.bookshop.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.bookshop.models.User;
import com.app.bookshop.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAllByEmailProvider(String provider) {
		List<User> users = userRepository.findAll()
						   .stream()
						   .filter(user -> user.getEmail().endsWith(provider))
						   .collect(Collectors.toList());
		return users;
	}

	@Override
	public void markAllInactiveUsers(LocalDateTime dateTime) {
		List<User> inactiveUsers = userRepository.findAll()
				   .stream()
				   .filter(user -> user.getLastTimeLoggedIn().isBefore(dateTime))
				   .collect(Collectors.toList());
		
		for(User user : inactiveUsers) {
			user.setIsDeleted(true);
			System.out.println(user.toString());
		}
		
		removeAllInactiveUsers(inactiveUsers);
	}

	@Override
	public void removeAllInactiveUsers(List<User> inactiveUsers) {
		for(User user : inactiveUsers) {
			userRepository.delete(user);
		}
	}

}

package com.eweb.service;

import java.util.List;

import com.eweb.model.User;

public interface UserService {
	// String findAge(String id);

	// List<User> getAllUser();

	User getUserById(int userId);

	int addUser(User user);

	List<User> getAllUser();

	int updateUser(User user);

	int deleteUser(Integer id);
}
package com.binsin.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binsin.store.dao.UserDao;
import com.binsin.store.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	public User getUserById(int userId) {
		return userDao.getUserById(userId);
	}
	
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}
	
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
}

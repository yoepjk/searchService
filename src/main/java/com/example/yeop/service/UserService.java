package com.example.yeop.service;

import com.example.yeop.model.User;

public interface UserService {
	  
	 public User findUserByEmail(String email);
	 
	 public void saveUser(User user);
}
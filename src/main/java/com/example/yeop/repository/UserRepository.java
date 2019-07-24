package com.example.yeop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.yeop.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
 
	User findByEmail(String email);
}
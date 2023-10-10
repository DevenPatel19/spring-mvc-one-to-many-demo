package com.codingdojo.springmvconetomanydemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.springmvconetomanydemo.models.User;
import com.codingdojo.springmvconetomanydemo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	// Find all
	public List<User> allUsers(){
		return userRepo.findAll();
	}
	
	//Find one
	public User findUserById(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	
	//Create 
	public User createUser(User newUser) {
		return userRepo.save(newUser);
	}
	// Update
		public User updatedUser(User user) {
			return userRepo.save(user);
		}
		
	// Delete
		public void deleteUser(Long id) {
			userRepo.deleteById(id);
		}
}

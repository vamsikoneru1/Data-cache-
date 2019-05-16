package com.vikash.repository;

import org.springframework.data.repository.CrudRepository;

import com.vikash.modal.User;

public interface UserRepository extends CrudRepository<User, Integer> {	
	
	public User findByUsernameAndPassword(String username, String password);
	
	public User findByUsername(String Username);
	public User findByFirstname(String Firstname);
	public User findById(String id);
	
}

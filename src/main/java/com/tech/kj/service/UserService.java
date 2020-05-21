package com.tech.kj.service;

import java.util.List;
import java.util.Optional;

import com.tech.kj.entity.Users;

public interface UserService {
	public List<Users> getAllUsers();
	
	public void save(Users user);

	Optional<Users> getUserById(int id);
}

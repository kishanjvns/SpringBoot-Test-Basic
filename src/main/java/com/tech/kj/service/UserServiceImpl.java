package com.tech.kj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.tech.kj.entity.Users;
import com.tech.kj.repository.UsersRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public List<Users> getAllUsers() {
		return Lists.newArrayList(usersRepository.findAll());
	}

	@Override
	public Users save(Users user) {
		Users users = usersRepository.save(user);
		return users;

	}

	@Override
	public Optional<Users> getUserById(int id) {
		return usersRepository.findById(id);
	}

}

package com.tech.kj.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.kj.entity.Users;
import com.tech.kj.service.UserService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping()
	public ResponseEntity<List<Users>> getUsers() throws NotFoundException {
		List<Users> users = userService.getAllUsers();
		if (!users.isEmpty()) {
			return ResponseEntity.ok().body(users);
		} else {
			throw new NotFoundException("no data available");
		}
	}

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity saveUser(@RequestBody Users user) {
		Users userCreated=  userService.save(user); 
		return ResponseEntity.ok().body(userCreated); 
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable int id) throws NotFoundException {
		Optional<Users> users = userService.getUserById(id);
		if (users.isPresent()) {
			return ResponseEntity.ok().body(users.get());
		} else { 
			throw new NotFoundException("no data available");
		}
	}
}

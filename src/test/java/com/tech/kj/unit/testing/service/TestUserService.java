package com.tech.kj.unit.testing.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tech.kj.entity.Users;
import com.tech.kj.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserService {
	@Autowired
	private UserService userService;
	@Test	
	public void testCreateUser() {
		Users createdUser=userService.save(mockUsers());
		Optional<Users> users=userService.getUserById(createdUser.getId());
		System.out.println("id "+createdUser.getId());
		assertEquals(createdUser.getId(), users.get().getId());
	}
	
	public Users mockUsers() {
		Users user=new Users();
		user.setFirstName("feddy");
		user.setLastName("todd");
		user.setEmail("feddy123@gmail.com");
		user.setUserName("feddy123");
		user.setPassword("12345");
		return user;
	}
}

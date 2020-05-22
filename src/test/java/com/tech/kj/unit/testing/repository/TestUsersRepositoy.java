package com.tech.kj.unit.testing.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tech.kj.entity.Users;
import com.tech.kj.repository.UsersRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUsersRepositoy {	
	@Autowired
	UsersRepository usersRepository;
	
	@Test
	public void testCreateUser() {
		Users createdUser=usersRepository.save(mockUsers());   
		Optional<Users> users=usersRepository.findById(createdUser.getId());
		assertEquals(createdUser.getId(), users.get().getId());
	}
	
	public Users mockUsers() {
		Users user=new Users();
		user.setFirstName("Anna");
		user.setLastName("D");
		user.setEmail("anna123@gmail.com");
		user.setUserName("anna123");
		user.setPassword("12345");
		return user;
	}
}

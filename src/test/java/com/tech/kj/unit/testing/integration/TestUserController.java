package com.tech.kj.unit.testing.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.tech.kj.SpringBootTestBasicApplication;
import com.tech.kj.entity.Users;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootTestBasicApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class TestUserController {

	TestRestTemplate testRestTemplate;

	@Before
	public void init() {
		testRestTemplate = new TestRestTemplate();
	}

	@Test
	public void testGetUserById() throws Exception {
		ResponseEntity<String> response = testRestTemplate.getForEntity("http://localhost:8080/blogs/user" + "/1",
				String.class);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testCreateUser() {		
		HttpHeaders headers = new HttpHeaders();

		headers.set("Content-Type", "application/json");
		HttpEntity<Users> entity = new HttpEntity<Users>(mockUsers(), headers);

		ResponseEntity<String> response = testRestTemplate.postForEntity("http://localhost:8080/blogs/user", entity,
				String.class);
		System.err.println("res " + response);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	public Users mockUsers() {
		Users user = new Users();
		user.setFirstName("Tod");
		user.setLastName("pan");
		user.setEmail("tod123@gmail.com");
		user.setUserName("tod123");
		user.setPassword("12345");
		return user;
	}

}

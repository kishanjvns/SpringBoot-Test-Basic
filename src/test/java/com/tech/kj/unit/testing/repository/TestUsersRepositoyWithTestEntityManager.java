/*
* @DataJpaTest
* it load the testContext and allow us to perform the Unit testing at repository
* level.
* By default it use the in-memory database
* For that we need to add the H2 in pom as a test scope.
* with application.properties
* spring.datasource.url = jdbc:h2:file:C:/data/sample
* spring.h2.console.enabled=true
* spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
* spring.datasource.username=sa
* spring.datasource.password=
* spring.datasource.driver-class-name=org.h2.Driver
*
*If you want @DataJpa test use persitent data store instead of in-memory than
*@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
*and delete the appliction.properties from the test/resources dir and cooment our the
*h2 dependency.
*
*
*/
package com.tech.kj.unit.testing.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.tech.kj.entity.Users;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class TestUsersRepositoyWithTestEntityManager {
	@Autowired TestEntityManager entityManager;	
	
	@Test
	@Transactional
	public void testCreateUser() {
		Users createdUser=entityManager.persist(mockUsers());
		Users users=entityManager.find(Users.class, createdUser.getId());
		System.out.println("id "+createdUser.getId());
		assertEquals(createdUser.getId(), users.getId());
	}
	
	@Test
	public void testFetchUsers() {
		Users users= entityManager.find(Users.class, 9);
		System.out.println(users);
		assertNotNull(users, "record found");
	}
	
	public Users mockUsers() {
		Users user=new Users();
		user.setFirstName("Fred");
		user.setLastName("todd");
		user.setEmail("fred123@gmail.com");
		user.setUserName("fed123");
		user.setPassword("12345");
		return user;
	}
}

package com.like.demo.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.like.demo.model.User;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	/*@Before
	public void setUp() {
		User user1 = new User("test01","테스트유저1","12345678");
		User user2 = new User("test02","테스트유저2","12345678");
		User user3 = new User("test03","테스트유저3","12345678");
		User user4 = new User("test04","테스트유저4","12345678");
				
		userService.registerUser(user1);
		userService.registerUser(user2);
		userService.registerUser(user3);
		userService.registerUser(user4);
	}*/
	
	@Test
	public void test() {
		// Given
		User user1 = new User("test01","테스트유저1","12345678");
				
		// When
		userService.registerUser(user1);
		
		// Then
		assertThat(user1.getUserId(), is("test01"));
		assertThat(user1.getUserName(), is("테스트유저1"));
		assertThat(user1.getPassword(), is("123456781"));
		
		//fail("Not yet implemented");
	}

}

package com.musinsa.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.moais.demo.dto.User;
import com.moais.demo.service.UserService;

@SpringBootTest
class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	void testSignupUser() throws Exception {
		User user = User.builder()
						.email("email")
						.password("password")
						.checkPassword("password")
						.build();
		userService.signupUser(user);
	}

	@Test
	void testSigninUser() {
	}

}



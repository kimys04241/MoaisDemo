package com.musinsa.demo.auth.jwt;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.moais.demo.auth.jwt.JwtAuthentification;

@SpringBootTest
class JwtAuthentificationTest {

	@Autowired
	private JwtAuthentification jwt;
	
	@Test
	void testMakeAllToekn() throws Throwable {
		
		Map<String, String> tokens = jwt.makeAllToekn("userId");
	}

}



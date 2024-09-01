package com.example.SpringSecurity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurityApplicationTests {

	@Test
	void contextLoads() {
		testAdd();
	}

	@Test
	void testAdd(){
		int a = 4;
		int b = 5;

		int resutl = a + b;

		assertEquals(resutl, 9);
	}
}

package com.junit.junit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
	
	private final UserService userService = new UserService();

	@Test
	void shouldReturnUserNameWhenIdIsOne() {

		String result = userService.getUserName(1);
		String expectedResult = "Ravikiran";
		assertEquals(expectedResult, result);
	}

	@Test
	void shouldReturnUnknownUserWhenIdIsNotFound() {

		String result = userService.getUserName(100);

		assertEquals("Unknown User", result);
	}
}

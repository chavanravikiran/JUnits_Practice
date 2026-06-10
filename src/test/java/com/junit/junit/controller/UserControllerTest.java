package com.junit.junit.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.junit.junit.service.UserService;

public class UserControllerTest {
	
	@Test
	void shouldReturnUserName() throws Exception {

		UserService userService = Mockito.mock(UserService.class);

		when(userService.getUserName(1)).thenReturn("Ravikiran");

		UserController controller = new UserController(userService);

		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

//		mockMvc.perform(get("/users/1")).andExpect(status().isOk()).andExpect(content().string("Ravikrian"));
	}
}

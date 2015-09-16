package com.smartbank.atm.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

public class LoginControllerTest {

	@Test
	public void testLoadPage() throws Exception {
		LoginController controller = new LoginController();
		MockMvc mockMvc = standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/jsp/login.jsp"))
				.build();

		mockMvc.perform(get("/login"))
		.andExpect(status().isOk())
		.andExpect(view().name("login"))
		.andExpect(model().attributeExists("loginRequest"));
	}
}

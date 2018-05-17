package com.example.tokenservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;

import br.com.auth.domain.User;
import br.com.auth.repository.UserRepository;
import br.com.auth.web.AuthController;

public class AuthControllerTest extends DemoApplicationTests {

	private MockMvc mockMvc;
	
	@Autowired
	private AuthController authController;
	
	@Autowired
	private UserRepository userRepository;
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(),
			Charset.forName("utf8"));
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
	}
	
	@Test
	public void when_user_invalid_should_return_401_status() throws Exception {
		User user = new User();
		user.setEmail("josevieira.dev@gmail.com");
		user.setPassword("123123123");
		
		Gson gson = new Gson();
		String jsonInString = gson.toJson(user);
		
		this.mockMvc.perform(post("/")
				.contentType(contentType)
				.content(jsonInString)).andExpect(status().isUnauthorized());
	}
	
	@Test
	public void when_user_valid_should_return_200_status() throws Exception {
		User user = new User();
		user.setEmail("josevieira.dev@gmail.com");
		user.setPassword("123123123");
		
		userRepository.save(user);
		
		Gson gson = new Gson();
		String jsonInString = gson.toJson(user);
		
		this.mockMvc.perform(post("/")
				.contentType(contentType)
				.content(jsonInString)).andExpect(status().isOk());
	}
	
}

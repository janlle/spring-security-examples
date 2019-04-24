package com.leone.security.web.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void whenQuerySuccess() throws Exception{
		String result = mockMvc.perform(MockMvcRequestBuilders.get("/user")
				.param("username", "test")
				.param("salary", "12000")
				.param("password", "123456")
				.param("xxx", "xxx")
//				.param("size", "15")
//				.param("page", "3")
				.param("sort", "salary,desc")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
				.andReturn().getResponse().getContentAsString();
		System.out.println(result);
	}
	
	@Test
	public void whenGenInfoSuccess() throws Exception{
		
		String result = mockMvc.perform(MockMvcRequestBuilders.get(("/user/1"))
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("username").value("tom"))
				.andReturn().getResponse().getContentAsString();
		System.out.println(result);
	}
	
	
	@Test
	public void whenGenInfoFail() throws Exception{
		String result = mockMvc.perform(MockMvcRequestBuilders.get(("/user/a"))
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().is4xxClientError())
				.andReturn().getResponse().getContentAsString();
		System.out.println(result);
	}
	
	
	@Test
	public void whenCreateSuccess() throws Exception{
		Date date = new Date();
		long time = date.getTime();
		System.out.println(time);
		String content = "{\"username\":\"tom\",\"password\":null,\"birthday\":"+time+"}";
		String result = mockMvc.perform(MockMvcRequestBuilders.post(("/user"))
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(content))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
				.andReturn().getResponse().getContentAsString();
		System.out.println(result);
	}
	
	
	@Test
	public void whenUpdateSuccess() throws Exception{
		Date date = new Date(LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
		long time = date.getTime();
		System.out.println(time);
		String content = "{\"id\":\"1\",\"username\":\"tom\",\"password\":null,\"birthday\":"+time+"}";
		String result = mockMvc.perform(MockMvcRequestBuilders.put(("/user/1"))
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(content))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
				.andReturn().getResponse().getContentAsString();
		System.out.println(result);
	}
	
	@Test
	public void whenDeleteSuccess() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.delete("/user/1")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	
}
//Elliot
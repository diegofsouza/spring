/**
 * 
 */
package com.spring.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spring.BaseControllerTest;

/**
 * @author dsouza.bh@gmail.com
 */
public class UserControllerTest extends BaseControllerTest {

	/**
	 * Test method for {@link com.spring.controller.UserController#list()}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/users"))
		.andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(content().encoding("UTF-8"))
		.andExpect(jsonPath("$", hasSize(greaterThan(1))));
	}

}

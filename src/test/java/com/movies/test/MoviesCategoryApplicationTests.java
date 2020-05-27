package com.movies.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.movies.MoviesCategoryApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MoviesCategoryApplication.class)
class MoviesCategoryApplicationTests extends AbstractTest {

	// TODO:Uncomment commented code before invoke these methods
	// @BeforeEach
	public void setUp() {
		super.setUp();
	}

	// TODO:Uncomment commented code before invoke these methods
	// @Test
	public void getMoviesList() throws Exception {
		String uri = "/movies";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertTrue(content.contains("success"));
	}

	// TODO:Uncomment commented code before invoke these methods
	// @Test
	public void finById() throws Exception {
		String uri = "/movies/9";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertTrue(content.contains("success"));
	}

	// TODO:Uncomment commented code before invoke these methods
	// @Test
	public void deleteMovies() throws Exception {
		String uri = "/movies/9";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "{\"body\":{\"success\":true},\"statusCode\":200}");
	}

}

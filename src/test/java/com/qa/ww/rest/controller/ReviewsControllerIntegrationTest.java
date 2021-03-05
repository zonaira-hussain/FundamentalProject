package com.qa.ww.rest.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.ww.persistence.domain.Reviews;
import com.qa.ww.persistence.repository.ReviewsRepository;


@SpringBootTest
@AutoConfigureMockMvc
//@Sql(scripts = {"classpath:schema.sql","classpath:data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class ReviewsControllerIntegrationTest {

	@Autowired
	private MockMvc mockMVC;
	
	
	@Autowired
	private ObjectMapper map;
	
	
	@Autowired
	private ReviewsRepository repo;
	
	
	private final String URI = "/reviews";
	
	private final Reviews test_review1= new Reviews(1,"Chowder","comedy/animation",4,"Funny show");
	private final Reviews test_review2= new Reviews(2,"dr Stone","anime/science fiction",4,"interesting");
	
	private final List<Reviews> REVIEWS = List.of(test_review1, test_review2);
	private final String genre = "science";
	private final String title = "Stone";
	
	@BeforeEach
	void setup() {
		this.repo.saveAll(REVIEWS);
	}
	
	
	 @Test
	    void readAllTest() throws Exception {
	        this.mockMVC.perform(get(URI + "/readAll").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
	                .andExpect(content().json(this.map
	                        .writeValueAsString(REVIEWS.stream().collect(Collectors.toList()))));
	   }
	   

	
    @Test
    void readByIdTest() throws Exception {
        this.mockMVC.perform(get(URI + "/read/" + test_review1.getReviewID()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(this.map.writeValueAsString(test_review1)));
    }
    
    
    @Test
    void findByGenreTest() throws Exception {
        this.mockMVC.perform(get(URI + "/read/byGenre/" + genre).accept(MediaType.APPLICATION_JSON))
                .andExpect(content().json(this.map.writeValueAsString(REVIEWS.stream()
                		.filter(e -> e.getGenre().equals(test_review2.getGenre())).collect(Collectors.toList()))));        
                        		
    }
    @Test
    void findByTitleTest() throws Exception{
        this.mockMVC.perform(get(URI + "/read/byTitle/" + title).accept(MediaType.APPLICATION_JSON))
        .andExpect(content().json(this.map.writeValueAsString(REVIEWS.stream()
        		.filter(e -> e.getTitle().equals(test_review2.getTitle())).collect(Collectors.toList())))); 
    }
	
	@Test
	void testCreate() throws Exception{
		String resultString = this.mockMVC
				.perform(post(URI + "/create").contentType(MediaType.APPLICATION_JSON).content(this.map.writeValueAsString(test_review1)))
				.andExpect(status().isCreated()).andReturn().getRequest().getContentAsString();
		Reviews result = this.map.readValue(resultString, Reviews.class);
		assertThat(result).isEqualTo(test_review1);
	}
	
	@Test
	void updateTest() throws Exception{
		this.mockMVC.perform(put(URI + "/update/" + test_review1.getReviewID()).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(this.map.writeValueAsString(test_review1)))
		.andExpect(status().isAccepted())
		.andExpect(content().json(this.map.writeValueAsString(test_review1)));
	}
	
    @Test
    void testDelete() throws Exception {
        this.mockMVC.perform(delete(URI + "/delete/" + test_review1.getReviewID())).andExpect(status().isNoContent());
    }
	
}

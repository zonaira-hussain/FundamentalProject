package com.qa.ww.rest.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.qa.ww.persistence.domain.Reviews;
import com.qa.ww.service.ReviewsService;

@SpringBootTest
@ActiveProfiles(profiles = "test")
public class ReviewsControllerUnitTest {
	
	@Autowired
	private ReviewsController controller;
	
	@MockBean
	private ReviewsService service;
	
	
	private final Reviews test_review= new Reviews(1,"Chowder","comedy/animation",4,"Funny show");
	private final List<Reviews> REVIEWS = List.of(test_review);
	private final String genre = "comedy";
	private final String title = "chow";
	
	@Test
	void createTest() throws Exception{
		when(this.service.create(test_review)).thenReturn(test_review);
		assertThat(new ResponseEntity<Reviews>(test_review, HttpStatus.CREATED))
		.isEqualTo(this.controller.create(test_review));
		verify(this.service, atLeastOnce()).create(test_review);
		
	}
	
	@Test
	void readAllTest() throws Exception{
		when(this.service.readAll()).thenReturn(REVIEWS.stream().collect(Collectors.toList()));
		assertThat(this.controller.readAll().getBody().isEmpty()).isFalse();
		verify(this.service, atLeastOnce()).readAll();
	}
	
	@Test
	void readByIdTest() throws Exception{
		when(this.service.readById(test_review.getReviewID())).thenReturn(test_review);
		assertThat(new ResponseEntity<Reviews>(test_review,HttpStatus.OK))
		.isEqualTo(this.controller.readById(test_review.getReviewID()));
		verify(this.service, atLeastOnce()).readById(test_review.getReviewID());
	}
	
	@Test
	void readByGenreTest() throws Exception{
		when(this.service.readByGenre(genre)).thenReturn(REVIEWS.stream().collect(Collectors.toList()));
		assertThat(this.controller.readByGenre(genre))
		.isEqualTo(new ResponseEntity<List<Reviews>>(REVIEWS.stream().collect(Collectors.toList()),HttpStatus.OK));
		verify(this.service, atLeastOnce()).readByGenre(genre);
	}
	
	@Test
	void readByTitleTest() throws Exception{
		when(this.service.readByTitle(title)).thenReturn(REVIEWS.stream().collect(Collectors.toList()));
		assertThat(this.controller.readByTitle(title))
		.isEqualTo(new ResponseEntity<List<Reviews>>(REVIEWS.stream().collect(Collectors.toList()),HttpStatus.OK));
		verify(this.service, atLeastOnce()).readByTitle(title);
	}
	
	@Test
	void updateTest() throws Exception{
		when(this.service.update(test_review.getReviewID(), test_review)).thenReturn(test_review);
		assertThat(new ResponseEntity<Reviews>(test_review, HttpStatus.ACCEPTED))
		.isEqualTo(this.controller.update(test_review.getReviewID(), test_review));
		verify(this.service, atLeastOnce()).update(test_review.getReviewID(), test_review);
	}
	
	@Test
	void deleteTest() throws Exception{
		this.controller.delete(test_review.getReviewID());
		verify(this.service, atLeastOnce()).delete(test_review.getReviewID());
	}
	
	
}

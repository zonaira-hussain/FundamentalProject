package com.qa.ww.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.ww.persistence.domain.Reviews;
import com.qa.ww.persistence.repository.ReviewsRepository;

@SpringBootTest
public class ReviewsServiceIntegrationTest {
	
	@Autowired
	private ReviewsService service;
	
	@Autowired
	private ReviewsRepository repo;
	

	private final Reviews test_review= new Reviews(1,"Chowder","comedy/animation",4,"Funny show");
	private final List<Reviews> REVIEWS = List.of(test_review);
	private final String genre = "comedy";
	private final String title = "Chow";
	
	@BeforeEach
	void setup() {
		this.repo.saveAll(REVIEWS);
	}
	
	@Test
	void createTest() throws Exception{
		assertThat(this.service.create(test_review)).isEqualTo(test_review);
	}
	
	@Test
	void readAllTest() throws Exception{
		assertThat(this.service.readAll()).isEqualTo(REVIEWS);
	}
	
	@Test
	void readByIdTest() throws Exception{
		assertThat(this.service.readById(test_review.getReviewID())).isEqualTo(test_review);
	}
	
	@Test
	void readByGenreTest() throws Exception{
		assertThat(this.service.readByGenre(genre)).isEqualTo(REVIEWS);
	}
	
	@Test
	void readByTitleTest() throws Exception{
		assertThat(this.service.readByTitle(title)).isEqualTo(REVIEWS);
	}
	
	@Test
	void updateTest() throws Exception{
		assertThat(this.service.update(test_review.getReviewID(), test_review))
		.isEqualTo(test_review);
	}
	
	@Test
	void deleteTest() throws Exception{
		assertThat(this.service.delete(test_review.getReviewID())).isTrue();
	}

}

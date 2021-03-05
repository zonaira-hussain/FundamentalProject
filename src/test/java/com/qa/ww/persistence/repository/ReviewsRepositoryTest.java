package com.qa.ww.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.ww.persistence.domain.Reviews;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class ReviewsRepositoryTest {
	
	@Autowired
	private ReviewsRepository repo;
	
	private final Reviews test_review1= new Reviews("Chowder","comedy/animation",4,"Funny show");
	private final Reviews test_review2= new Reviews("dr Stone","anime/science fiction",4,"interesting");
	private final Reviews test_review3= new Reviews("Good Girls","comedy/action",5,"oof Rio tho");
	
	private final List<Reviews> DATA_SET = List.of(test_review1,test_review2,test_review3);
	private final List<Reviews> byGenre = List.of(test_review3);
	private final String genre = "action";
	private final List<Reviews> byTitle = List.of(test_review3);
	private final String title = "Good";
	
	
	@BeforeAll
	void setup() {
		this.repo.saveAll(DATA_SET);
		this.repo.saveAll(byGenre);
		this.repo.saveAll(byTitle);
	}
	
	@Test
	void findByGenreTest() throws Exception{
		assertThat(this.repo.findByGenreContainsIgnoreCase(genre).stream().map(e -> e.getGenre())
		.collect(Collectors.toList()))
             .isEqualTo(byGenre.stream().filter(e -> e.getGenre().equals(test_review3.getGenre()))
                     .map(e -> e.getGenre()).collect(Collectors.toList()));

	}
	
	@Test
	void findByTitleTest() throws Exception{
		assertThat(this.repo.findByTitleContainsIgnoreCase(title).stream().map(e -> e.getTitle())
		.collect(Collectors.toList()))
             .isEqualTo(byTitle.stream().filter(e -> e.getTitle().equals(test_review3.getTitle()))
                     .map(e -> e.getTitle()).collect(Collectors.toList()));
	}

}

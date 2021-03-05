package com.qa.ww.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.ww.persistence.domain.Reviews;
import com.qa.ww.persistence.repository.ReviewsRepository;

@SpringBootTest
public class ReviewsServiceUnitTest {
	
	@Autowired
	private ReviewsService service;
	
	@MockBean
	private ReviewsRepository repo;
	
	private final Reviews test_review1= new Reviews(1,"Chowder","comedy/animation",4,"Funny show");
	private final Reviews test_review2= new Reviews(2,"dr Stone","anime/science fiction",4,"interesting");
	private final Reviews test_review3= new Reviews(3,"Good Girls","comedy/action",5,"oof Rio tho");
	
	private final List<Reviews> REVIEWS = List.of(test_review1,test_review2,test_review3);
	private final List<Reviews> byGenre = List.of(test_review1, test_review3);
	private final String genre = "comedy";
	private final List<Reviews> byTitle = List.of(test_review3);
	private final String title = "Good";
	
	@Test
	void testCreate() throws Exception {
		Mockito.when(this.repo.save(test_review1)).thenReturn(test_review1);
		assertThat(this.service.create(test_review1)).isEqualTo(test_review1);
		Mockito.verify(this.repo, Mockito.times(1)).save(test_review1);
	}
	
	@Test
	void testReadAll() throws Exception{
		when(this.repo.findAll()).thenReturn(REVIEWS);
		assertThat(this.service.readAll().isEmpty()).isFalse();
		verify(this.repo, Mockito.times(1)).findAll();	
	}
	
	@Test
	void testReadByGenre() throws Exception{
		when(this.repo.findByGenreContainsIgnoreCase(genre)).thenReturn(byGenre);
		assertThat(this.service.readByGenre(genre)).isEqualTo(byGenre);
		verify(this.repo, atLeastOnce()).findByGenreContainsIgnoreCase(genre);
	}
	
	@Test
	void testReadByTitle() throws Exception{
		when(this.repo.findByTitleContainsIgnoreCase(title)).thenReturn(byTitle);
		assertThat(this.service.readByTitle(title)).isEqualTo(byTitle);
		verify(this.repo, atLeastOnce()).findByTitleContainsIgnoreCase(title);
	}
	
	@Test
	void testReadByID() throws Exception{
		when(this.repo.findById(test_review1.getReviewID())).thenReturn(Optional.of(test_review1));
		assertThat(this.service.readById(test_review1.getReviewID())).isEqualTo(test_review1);
		verify(this.repo, atLeastOnce()).findById(test_review1.getReviewID());
	}
	
	@Test
	void testUpdate() throws Exception{
		when(this.repo.findById(test_review3.getReviewID())).thenReturn(Optional.of(test_review3));
		when(this.repo.save(test_review3)).thenReturn(test_review3);
		assertThat(this.service.update(test_review3.getReviewID(), test_review3)).isEqualTo(test_review3);
		verify(this.repo, atLeastOnce()).findById(test_review3.getReviewID());
		verify(this.repo, atLeastOnce()).save(test_review3);
	}
	
	@Test
	void testDelete() throws Exception{
		boolean found = false;
		when(this.repo.existsById(test_review2.getReviewID())).thenReturn(found);
		assertThat(this.service.delete(test_review2.getReviewID())).isNotEqualTo(found);
		verify(this.repo, atLeastOnce()).existsById(test_review2.getReviewID());
		
	}
	

}

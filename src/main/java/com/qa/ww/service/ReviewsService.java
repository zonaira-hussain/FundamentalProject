package com.qa.ww.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.ww.persistence.domain.Reviews;
import com.qa.ww.persistence.repository.ReviewsRepository;
import com.qa.ww.service.exception.ReviewsNotFoundException;

@Service
public class ReviewsService {
	
	private ReviewsRepository repo;

	@Autowired
	public ReviewsService(ReviewsRepository repo) {
		super();
		this.repo = repo;
	}
	
	//methods
	
	public Reviews create(Reviews review) {
		Reviews created = this.repo.save(review);
		return created;
		
	}
	
	public List<Reviews> readAll() {
		List<Reviews> allFromDb = this.repo.findAll();
		return allFromDb;
	}
	
	public List<Reviews> readByGenre(String genre) {
		List<Reviews> listGenreFromDb = this.repo.findByGenreContainsIgnoreCase(genre);
		return listGenreFromDb;
		
	}
	
	public List<Reviews> readByTitle(String title) {
		List<Reviews> titleFromDb = this.repo.findByTitleContainsIgnoreCase(title);
		return titleFromDb;
	}
	
	public Reviews readById(int reviewID) {
		Reviews thingReadFromDb = this.repo.findById(reviewID).orElseThrow(ReviewsNotFoundException::new);
		return thingReadFromDb;
		
	}
	
	public Reviews update(int reviewID, Reviews review) {
		//grabs the thing we want to change from the db
		Reviews thingToUpdate = this.repo.findById(reviewID).orElseThrow(ReviewsNotFoundException::new);
		//here's the object we want to plug in instead:
		thingToUpdate.setGenre(review.getGenre());
		thingToUpdate.setRating(review.getRating());
		thingToUpdate.setSummary(review.getSummary());
		thingToUpdate.setTitle(review.getTitle());
		// save the changed object to the db
		return this.repo.save(thingToUpdate);
		
	}
	
	public boolean delete(int reviewID) {
		// tries to delete the object first
		this.repo.deleteById(reviewID);
		//checks if that object  we tried to delete still exists
		return !this.repo.existsById(reviewID);
		
		
	}

}

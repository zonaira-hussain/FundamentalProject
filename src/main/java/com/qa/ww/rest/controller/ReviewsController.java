package com.qa.ww.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.ww.persistence.domain.Reviews;
import com.qa.ww.service.ReviewsService;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {
	
	private ReviewsService service;
	
	@Autowired
	public ReviewsController(ReviewsService service) {
		super();
		this.service = service;
	}

	//read all
	@GetMapping("/readAll")
	public ResponseEntity<List<Reviews>> readAll(){
		return ResponseEntity.ok(this.service.readAll());
	}
	
	//read by title
	@GetMapping("/read/byTitle/{title}")
	public ResponseEntity<List<Reviews>> readByTitle(@PathVariable String title){
		return ResponseEntity.ok(this.service.readByTitle(title));
	}
	
	//read by genre
	@GetMapping("/read/byGenre/{genre}")
	public ResponseEntity<List<Reviews>> readByGenre(@PathVariable String genre){
		return ResponseEntity.ok(this.service.readByGenre(genre));
	}
	
	
	//read by id
	@GetMapping("/read/{reviewID}")
	public ResponseEntity<Reviews> readById(@PathVariable int reviewID){
		Reviews returnedObject = this.service.readById(reviewID);
		return ResponseEntity.ok(returnedObject);
	}
	
	
	//update by id
	@PutMapping("/update/{reviewID}")
	public ResponseEntity<Reviews> update(@PathVariable int reviewID, @RequestBody Reviews r) {
		Reviews updatedObject = this.service.update(reviewID, r);
		return new ResponseEntity<>(updatedObject, HttpStatus.ACCEPTED);
	}
	
	//create
	@PostMapping("/create")
	public ResponseEntity<Reviews> create(@RequestBody Reviews review){
		Reviews createdObject = this.service.create(review);
		return new ResponseEntity<>(createdObject, HttpStatus.CREATED);
	}
	
	//delete by id
	@DeleteMapping("/delete/{reviewID}")
	public ResponseEntity<Reviews> delete(@PathVariable int reviewID){
		if (this.service.delete(reviewID)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

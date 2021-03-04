package com.qa.ww.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.ww.persistence.domain.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews, Integer> {
	
	List<Reviews> findByGenreContainsIgnoreCase(String genre);
	
	List<Reviews> findByTitleContainsIgnoreCase(String title);

}

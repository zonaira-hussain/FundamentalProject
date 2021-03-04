package com.qa.ww.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Reviews {
	
	//variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewID;
	
	@Column(unique = true, nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String genre;
	
	@Column(nullable = false)
	@Min(0)
	@Max(5)
	private int rating;
	
	@Column
	private String summary;

	public Reviews(String title, String genre, int rating, String summary) {
		super();
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.summary = summary;
	}




	


}

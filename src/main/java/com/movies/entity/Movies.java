package com.movies.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movies extends AuditableEntity {

	@Column(name = "title")
	private String title;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "starRating")
	private Long starRating;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Long getStarRating() {
		return starRating;
	}
	public void setStarRating(Long starRating) {
		this.starRating = starRating;
	}
	
	
}

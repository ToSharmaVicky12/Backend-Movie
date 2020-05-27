package com.movies.dto;


public class MoviesDto {

	private Long id;	
	private String title;
	private String category;
	private Long starRating;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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

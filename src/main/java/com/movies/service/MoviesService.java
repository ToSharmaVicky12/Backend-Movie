package com.movies.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.movies.dto.MovieFilter;
import com.movies.entity.Movies;

public interface MoviesService extends AuditableEntityService<Movies> {
	
	Movies findById(Long movieId);
	
	Page<Movies> find(MovieFilter filter, Pageable pageable);

}

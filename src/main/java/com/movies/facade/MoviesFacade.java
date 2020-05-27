package com.movies.facade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.movies.dto.MovieFilter;
import com.movies.dto.MoviesDto;

public interface MoviesFacade {

	Long save(MoviesDto moviesDto);

	MoviesDto findById(Long movieId);
	
	Page<MoviesDto> find(MovieFilter filter, Pageable pageable);

	void deleteById(Long movieId);


}

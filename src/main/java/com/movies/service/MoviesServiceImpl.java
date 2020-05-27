package com.movies.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.movies.dao.MoviesDao;
import com.movies.dto.MovieFilter;
import com.movies.entity.BaseAuditableService;
import com.movies.entity.Movies;
import com.movies.specification.MovieSpecificationGenerator;

@Service
@Transactional
public class MoviesServiceImpl extends BaseAuditableService<Movies> implements MoviesService{

	@Autowired
	private MoviesDao moviesDao;
	
	@Autowired
	private MovieSpecificationGenerator movieSpecificationGenerator;
	
	@Override
	public Movies save(Movies movies) {
		return moviesDao.save(movies);
	}

	@Override
	public Movies findById(Long movieId) {
		return moviesDao.findById(movieId).orElse(new Movies());
	}
	

	@Override
	public Page<Movies> find(MovieFilter filter, Pageable pageable) {
		var filterSpecification = movieSpecificationGenerator.byFilter(filter)
				.and(movieSpecificationGenerator.isUnarchived());
		return moviesDao.findAll(filterSpecification, pageable);
	}
	
}

package com.movies.dto2entity;

import org.springframework.stereotype.Service;

import com.movies.dto.MoviesDto;
import com.movies.entity.Movies;

@Service
public abstract class MoviesEntityConverter<T extends Movies>{

	public Movies convert(MoviesDto source) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

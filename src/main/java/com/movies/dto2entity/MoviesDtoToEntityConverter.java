package com.movies.dto2entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.movies.dao.MoviesDao;
import com.movies.dto.MoviesDto;
import com.movies.entity.Movies;

@Component
public class MoviesDtoToEntityConverter implements Converter<MoviesDto, Movies>{
	@Autowired
	private MoviesDao moviesDao;
	
	public Movies convert(MoviesDto source) {
		Movies target = new Movies();
        if (source.getId() != null) {
            target = moviesDao.findById(source.getId()).orElseThrow(null);
        }else {
            target = new Movies();
        }
        target.setTitle(source.getTitle());
        target.setCategory(source.getCategory());
        target.setStarRating(source.getStarRating());
        
        return target;
    }
}

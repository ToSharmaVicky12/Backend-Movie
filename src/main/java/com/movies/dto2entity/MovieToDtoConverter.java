package com.movies.dto2entity;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.movies.dto.MoviesDto;
import com.movies.entity.Movies;

@Component
public class MovieToDtoConverter implements Converter<Movies, MoviesDto> {

    @Override
    public MoviesDto convert(Movies source) {
    	MoviesDto target = new MoviesDto();
        target.setId(source.getId());
        target.setTitle(source.getTitle());
        target.setCategory(source.getCategory());
        target.setStarRating(source.getStarRating());
        return target;
    }

}

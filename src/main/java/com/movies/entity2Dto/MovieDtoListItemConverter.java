package com.movies.entity2Dto;

import org.springframework.stereotype.Component;

import com.movies.converter.base.ListAndItemConverter;
import com.movies.dto.MoviesDto;
import com.movies.entity.Movies;

@Component
public class MovieDtoListItemConverter implements ListAndItemConverter<Movies, MoviesDto> {

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

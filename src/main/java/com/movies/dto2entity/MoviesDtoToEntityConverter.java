package com.movies.dto2entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.movies.dao.MoviesDao;
import com.movies.dto.MoviesDto;
import com.movies.entity.Movies;

@Component
public class MoviesDtoToEntityConverter implements Converter<MoviesDto, Movies> {
	@Autowired
	private MoviesDao moviesDao;

	public Movies convert(MoviesDto source) {
		Movies target = new Movies();
		if (source.getId() != null) {
			Movies target1 = moviesDao.findById(source.getId()).orElseThrow(null);
			target.setTitle(target1.getTitle());
			target.setId(target1.getId());
			target.setChainId(target1.getChainId());
			target.setArchived(target1.getArchived());
			target.setAuditableStatus(target1.getAuditableStatus());
			target.setLastModifiedDate(target1.getLastModifiedDate());
			target.setCategory(target1.getCategory());
			target.setStarRating(target1.getStarRating());
		} else {
			target = new Movies();
		}
		target.setTitle(source.getTitle());
		target.setCategory(source.getCategory());
		target.setStarRating(source.getStarRating());
		return target;
	}
}

package com.movies.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Sort;

import com.movies.converter.base.ListAndItemConverter;
import com.movies.dto.MovieFilter;
import com.movies.dto.MoviesDto;
import com.movies.entity.Movies;
import com.movies.entity.Movies_;
import com.movies.service.MoviesService;
import com.movies.utils.PaginationUtils;

@Service
@Transactional
public class MoviesFacadeImpl implements MoviesFacade {

	@Autowired
	private MoviesService moviesService;
	
	@Autowired
	private Converter<MoviesDto, Movies> moviesDtoToEntityConverter;
	
	@Autowired
	private Converter<Movies, MoviesDto> movieToDtoConverter;
	
	@Autowired
	private ListAndItemConverter<Movies, MoviesDto> movieDtoListItemConverter;

	@Override
	@Transactional
	public Long save(MoviesDto moviesDto) {
		if (moviesDto.getId() != null) {
			return moviesService.updateAuditableEntity(moviesDtoToEntityConverter.convert(moviesDto));
		} else
			return moviesService.createAuditableEntity(moviesDtoToEntityConverter.convert(moviesDto));
	}
	
	@Override
	public MoviesDto findById(Long movieId) {
		return movieToDtoConverter.convert(moviesService.findById(movieId));
	}
	
	@Override
	public Page<MoviesDto> find(MovieFilter filter, Pageable pageable) {
		return moviesService.find(filter, PaginationUtils.sortByDefault(pageable, Sort.by(Movies_.TITLE)))
				.map(movieDtoListItemConverter::convert);
	}
	
	@Override
	@Transactional
	public void deleteById(Long movieId) {
		moviesService.deleteAuditableEntity(movieId);
	}
}

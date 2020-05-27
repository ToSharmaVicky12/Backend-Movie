package com.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movies.dto.MovieFilter;
import com.movies.dto.MoviesDto;
import com.movies.facade.MoviesFacade;
import com.movies.response.Response;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MoviesFacade moviesFacade;

	@SuppressWarnings("deprecation")
	@RequestMapping(method = { RequestMethod.PUT, RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Long> save(@RequestBody MoviesDto dto) {
		if (!(dto.getStarRating() <= 5 && dto.getStarRating() >= 0.5)) {
			return Response.errorResponse("Star rating should be between 0.5 to 5", 404);
		}
		return Response.successResponse(moviesFacade.save(dto));
	}

	@GetMapping(value = "/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<MoviesDto> findById(@PathVariable("movieId") Long movieId) {
		return Response.successResponse(moviesFacade.findById(movieId));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<List<MoviesDto>> find(@ModelAttribute MovieFilter filter, Pageable pageable) {
		return Response.pagedResponse(moviesFacade.find(filter, pageable));
	}

	@DeleteMapping(value = "/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<?> deleteById(@PathVariable("movieId") Long movieId) {
		moviesFacade.deleteById(movieId);
		return Response.successResponse();
	}

}

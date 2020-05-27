package com.movies.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.movies.entity.Movies;

@Repository
public interface MoviesDao extends JpaRepository<Movies, Long>, JpaSpecificationExecutor<Movies> {

}

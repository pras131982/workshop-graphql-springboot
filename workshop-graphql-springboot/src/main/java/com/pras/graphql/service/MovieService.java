package com.pras.graphql.service;

import java.util.List;

import com.pras.graphql.domain.Movie;


public interface MovieService {

    Movie addMovie(Movie movie);

    Movie findMovieById(Integer movieId);

    List<Movie> listMovies();
}

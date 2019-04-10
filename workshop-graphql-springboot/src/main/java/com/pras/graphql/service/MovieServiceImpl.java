package com.pras.graphql.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pras.graphql.domain.Director;
import com.pras.graphql.domain.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	private static List<Movie> movieList = new ArrayList<>();
	static {
		Movie movie = new Movie (1,  "Test Movie", 2000, "Test", 120.20, "Yes");
		movieList.add(movie);
	}

    @Override
    public Movie addMovie(Movie movie) {
    	movieList.add(movie);
        return movie;
    }

    @Override
    public Movie findMovieById(Integer movieId) {
    	Movie movie = null;
    	for (Movie tempmovie : movieList) {
    		if (tempmovie != null && tempmovie.getId() == movieId) {
    			movie = tempmovie;
    		}
    		
    	}
        return movie;
    }

    @Override
    public List<Movie> listMovies() {
        return movieList;
    }
}

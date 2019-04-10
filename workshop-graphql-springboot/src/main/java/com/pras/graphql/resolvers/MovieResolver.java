package com.pras.graphql.resolvers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.pras.graphql.domain.Actor;
import com.pras.graphql.domain.Director;
import com.pras.graphql.domain.Movie;
import com.pras.graphql.service.MovieService;

@Component
public class MovieResolver implements GraphQLResolver<Movie> {


    @Autowired
    private MovieService movieService;
    

    public Director director(Movie inputMovie) {
        Movie movie = movieService.findMovieById(inputMovie.getId());
        Director director = movie.getDirector();
        return director;
    }

    public List<Actor> actors(Movie movie, Integer total) {
        List<Actor> actorEntities = movieService.findMovieById(movie.getId()).getActors();
        if (actorEntities.size() == 0) {
            return null;
        }
        total = Math.min(total, actorEntities.size());
        return actorEntities
                .subList(0, total)
                .stream()
               // .map(actorEntityToActorConverter::convert)
                .collect(Collectors.toList());
    }

}

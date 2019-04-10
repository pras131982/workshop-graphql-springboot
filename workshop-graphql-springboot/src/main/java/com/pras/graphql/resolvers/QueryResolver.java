package com.pras.graphql.resolvers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pras.graphql.domain.Actor;
import com.pras.graphql.domain.Director;
import com.pras.graphql.domain.Movie;
import com.pras.graphql.domain.Pet;
import com.pras.graphql.enums.Animal;
import com.pras.graphql.service.ActorService;
import com.pras.graphql.service.DirectorService;
import com.pras.graphql.service.MovieService;

@Component
public class QueryResolver implements GraphQLQueryResolver {
	
    @Autowired
    private ActorService actorService;
    @Autowired
    private DirectorService directorService;

    @Autowired
    private MovieService movieService;

    public List<Pet> pets() {
        List<Pet> pets = new ArrayList<>();
        Pet aPet = new Pet();
        aPet.setId(1l);
        aPet.setName("Bill");
        aPet.setAge(9);
        aPet.setType(Animal.MAMMOTH);
        pets.add(aPet);
        return pets;
    }
    
    public List<Actor> listActors() {
        return actorService.listActors();
    }
    
    public List<Director> listDirectors() {
        return directorService
                .listDirectors()
                .stream()
                .collect(Collectors.toList());
    }

    public List<Movie> listMovies() {
        return movieService
                .listMovies()
                .stream()
                .collect(Collectors.toList());
    }

    public Movie getMovie(Integer movieId) {
        Movie movie = movieService.findMovieById(movieId);
        return movie;
    }
}
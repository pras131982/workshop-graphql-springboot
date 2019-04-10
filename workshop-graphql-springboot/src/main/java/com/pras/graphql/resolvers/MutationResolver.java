package com.pras.graphql.resolvers;

import static graphql.ErrorType.DataFetchingException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.pras.graphql.domain.Director;
import com.pras.graphql.domain.Movie;
import com.pras.graphql.publisher.DirectorPublisher;
import com.pras.graphql.publisher.MovieDirectorPublisher;
import com.pras.graphql.service.DirectorService;
import com.pras.graphql.service.MovieService;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

@Component
public class MutationResolver implements GraphQLMutationResolver {


    @Autowired
    private DirectorService directorService;

    @Autowired
    private MovieService movieService;
    
    @Autowired
    private MovieDirectorPublisher movieDirectorPublisher;
    
    @Autowired
    private DirectorPublisher directorPublisher;



    public Director addDirector(Integer id, String fullName, String country) {
        try {
        	Director request = new Director( id,  fullName,  country);
        	Director director = directorService.addDirector(request);
        	directorPublisher.publish(director);
            return director;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public List<Director> deleteDirector(Integer directorId) {
        directorService.deleteDirectorWithId(Integer.valueOf(directorId));
        return directorService
                .listDirectors();
    }

    public Movie addMovie(Integer id, String title, int year, String genre, Double budget, String trailer) {
        try {
        	Movie inputMovie = new Movie( id,  title,  year,  genre,  budget,  trailer);
            Movie movie = movieService.addMovie(inputMovie);
            movie.getDirector();
           movieDirectorPublisher.publish(movie);
            return movie;
        } catch (Exception ex) {
            ex.printStackTrace();
            // The purpose of this block is just showing how we could customize the errors
            //env.getExecutionContext().addError(customError(ex));
            throw ex;
        }
    }

    private GraphQLError customError(Exception ex) {
        return new GraphQLError() {
            @Override
            public String getMessage() {
                return ex.getMessage();
            }

            @Override
            public List<SourceLocation> getLocations() {
                return null;
            }

            @Override
            public ErrorType getErrorType() {
                return DataFetchingException;
            }
        };
    }
}

package com.pras.graphql.resolvers;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.pras.graphql.domain.Director;
import com.pras.graphql.domain.Movie;
import com.pras.graphql.publisher.DirectorPublisher;
import com.pras.graphql.publisher.MovieDirectorPublisher;

@Component
public class SubscriptionResolver implements GraphQLSubscriptionResolver {

    @Autowired
    private MovieDirectorPublisher movieDirectorPublisher;
    
    @Autowired
    private DirectorPublisher directorPublisher;

    public Publisher<Movie> listenDirectorMovies() {
        return movieDirectorPublisher.getPublisher();
    }
    
    public Publisher<Director> listenDirector() {
        return directorPublisher.getPublisher();
    }

}

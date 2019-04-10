package com.pras.graphql.publisher;

import org.springframework.stereotype.Component;

import com.pras.graphql.domain.Movie;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;


@Component
public class MovieDirectorPublisher {


    private final Flowable<Movie> publisher;

    private ObservableEmitter<Movie> emitter;

    public MovieDirectorPublisher() {
        Observable<Movie> movieUpdateObservable = Observable.create(emitter -> {
            this.emitter = emitter;
        });
        ConnectableObservable<Movie> connectableObservable = movieUpdateObservable.share().publish();
        connectableObservable.connect();
        publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
    }


    public void publish(final Movie movie) {
        emitter.onNext(movie);
    }

    public Flowable<Movie> getPublisher() {
/*        return publisher.filter(movie -> check(movie))
               // .map(converter::convert);
        		.map(movie -> movie);*/
    	
    	return publisher.map((movie) -> new Movie (movie.getId(), movie.getTitle(), movie.getYear(),movie.getGenre(), movie.getBudget(), movie.getTrailer() ));
    }

/*    private boolean check(Movie movie) {
        if (movie != null) {
            return true;
        }
        return false;
    }*/
}

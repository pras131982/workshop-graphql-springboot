package com.pras.graphql.publisher;

import org.springframework.stereotype.Component;

import com.pras.graphql.domain.Director;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;


@Component
public class DirectorPublisher {


    private final Flowable<Director> publisher;

    private ObservableEmitter<Director> emitter;

    public DirectorPublisher() {
        Observable<Director> movieUpdateObservable = Observable.create(emitter -> {
            this.emitter = emitter;
        });
        ConnectableObservable<Director> connectableObservable = movieUpdateObservable.share().publish();
        connectableObservable.connect();
        publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
    }


    public void publish(final Director director) {
        emitter.onNext(director);
    }

    public Flowable<Director> getPublisher() {
    	return publisher.map((source) -> new Director (source.getId(), source.getFullName(), source.getCountry()));
    }
}

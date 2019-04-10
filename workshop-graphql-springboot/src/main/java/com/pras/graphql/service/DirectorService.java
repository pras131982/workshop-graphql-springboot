package com.pras.graphql.service;

import java.util.List;

import com.pras.graphql.domain.Director;

public interface DirectorService {

    Director addDirector(Director entity);

    void deleteDirectorWithId(Integer directorId);

    List<Director> listDirectors();
}

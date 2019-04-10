package com.pras.graphql.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pras.graphql.domain.Director;

@Service
public class DirectorServiceImpl implements DirectorService {

	private static List<Director> directorList = new ArrayList<>();
	static {
		Director ac = new Director(1, "Pras Kumar", "US");
		directorList.add(ac);
	}

    @Override
    public Director addDirector(Director director) {
    	directorList.add(director);
        return director;
    }

    @Override
    public void deleteDirectorWithId(Integer directorId) {
    	Director tempDirector = null;
    	for (Director dir : directorList) {
    		if (dir != null && dir.getId() == directorId) {
    			tempDirector = dir;
    		}
    	}
    	
    	if (tempDirector != null) {
    		directorList.remove(tempDirector);
    	}
    }
    
    @Override
    public List<Director> listDirectors() {
        return directorList;
    }
}

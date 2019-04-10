package com.pras.graphql.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pras.graphql.domain.Actor;

@Service
public class ActorServiceImpl implements ActorService {
	private static List<Actor> actorList = new ArrayList<>();
	static {
		Actor ac = new Actor(1, "Pras", "US", "Male");
		actorList.add(ac);
	}

	@Override
	public List<Actor> listActors() {
		return actorList;
	}
}

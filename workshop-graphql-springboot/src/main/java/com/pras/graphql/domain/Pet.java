package com.pras.graphql.domain;

import com.pras.graphql.enums.Animal;

public class Pet {
    private long id;

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Animal getType() {
		return type;
	}

	public void setType(Animal type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private String name;

    private Animal type;

    private int age;
}
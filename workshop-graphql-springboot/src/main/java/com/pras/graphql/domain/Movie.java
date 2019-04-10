package com.pras.graphql.domain;

import java.util.List;

public class Movie {

    private Integer id;

    private String title;

    private int year;

    private String genre;

    private Double budget;

    private String trailer;

    private Director director;

    private List<Actor> actors;

    public Movie(Integer id, String title, int year, String genre, Double budget, String trailer) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.budget = budget;
        this.trailer = trailer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}

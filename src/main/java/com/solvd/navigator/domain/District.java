package com.solvd.navigator.domain;

import java.util.List;

public class District {

    private Long id;
    private String name;
    private City city;
    private List<Point> points;
    private List<Street> streets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Point> getPoints() {
        return points;
    }

    public List<Street> getStreets() {
        return streets;
    }

    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }

    public void setPoints(List<Point> points) {
        this.points = points;


    }
}

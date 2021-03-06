package com.solvd.navigator.domain;

import java.util.List;

public class District {

    private Long id;
    private String name;
    private City city;
    private List<Street> streets;

    public District() {
    }

    public District(String name, City city) {
        this.name = name;
        this.city = city;
    }

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

    public List<Street> getStreets() {
        return streets;
    }

    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }

    @Override
    public String toString() {
        return String.format("%s %s", city.getName(), this.getName());
    }
}

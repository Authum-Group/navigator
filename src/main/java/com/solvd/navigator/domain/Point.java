package com.solvd.navigator.domain;

import java.util.HashMap;
import java.util.Map;

public class Point {

    private Long id;
    private String name;
    private District district;
    private Street street;
    private Coordinate coordinate;
    private Type type;
    Map<Point, Double> availablePoints = new HashMap<>();

    public enum Type {

        BUS_STOP("Bus stop"),
        RESIDENTIAL_BUILDING("Residential building"),
        PUBLIC_PLACE("Public place"),
        ROAD("Road"),
        UNKNOWN_LOCATION("Unknown location");

        private final String title;

        public String getTitle() {
            return title;
        }

        Type(String title) {
            this.title = title;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Map<Point, Double> getAvailablePoints() {
        return availablePoints;
    }

    public void setAvailablePoints(Map<Point, Double> availablePoints) {
        this.availablePoints = availablePoints;
    }
}

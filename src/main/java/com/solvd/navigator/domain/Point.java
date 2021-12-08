package com.solvd.navigator.domain;

import java.util.HashMap;
import java.util.Map;

public class Point {

    private Long id;
    private String name;
    private District district;
    private Street street;
    private Coordinate coordinate;
    private PointType type;
    Map<Point, Double> availablePoints = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PointType getType() {
        return type;
    }

    public void setType(PointType type) {
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

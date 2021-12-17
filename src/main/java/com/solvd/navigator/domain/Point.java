package com.solvd.navigator.domain;

import org.apache.ibatis.annotations.MapKey;

import java.util.HashMap;
import java.util.Map;

public class Point {

    private Long id;
    private String name; // Дом, подъезд, участок - пофиг
    private Double latitude;
    private Double longitude;
    private Street street;
    private PointType type;
    private String description;
    Map<Point, Double> availablePoints = new HashMap<>();

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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public PointType getType() {
        return type;
    }

    public void setType(PointType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<Point, Double> getAvailablePoints() {
        return availablePoints;
    }

    public void setAvailablePoints(Map<Point, Double> availablePoints) {
        this.availablePoints = availablePoints;
    }

    @Override
    public java.lang.String toString() {
        return "Point{" +
                "name='" + name + '\'' +
                '}';
    }
}

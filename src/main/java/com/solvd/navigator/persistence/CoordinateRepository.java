package com.solvd.navigator.persistence;

import com.solvd.navigator.domain.Coordinate;

import java.util.List;

public interface CoordinateRepository {

    void create(Coordinate coordinate);

    List<Coordinate> findAll();

    Coordinate findById(Long id);

    void update(Coordinate coordinate);

    void delete(Coordinate coordinate);

}

package com.solvd.navigator.persistence;

import com.solvd.navigator.domain.Point;

import java.util.List;

public interface PointRepository {

    void create(Point point);

    List<Point> findAll();

    Point findById(Long id);

    void update(Point point);

    void delete(Point point);
}

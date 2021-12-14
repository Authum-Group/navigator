package com.solvd.navigator.algorithm;

import com.solvd.navigator.domain.Point;

import java.util.List;
import java.util.Optional;

public interface ShortestPathAlgorithm {

    Optional<Double> getPathLength(Point a, Point b);

    Optional<List<Point>> getShortPath(Point a, Point b);
}

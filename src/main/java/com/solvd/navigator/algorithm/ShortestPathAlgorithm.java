package com.solvd.navigator.algorithm;

import com.solvd.navigator.domain.Point;
import com.solvd.navigator.domain.exception.InvalidParametersException;

import java.util.List;
import java.util.Optional;

public interface ShortestPathAlgorithm {

    Optional<Double> getPathLength(Point from, Point to);

    Optional<List<Point>> getShortPath(Point from, Point to) throws InvalidParametersException;

    List<Point> getMatrixPoints();
}

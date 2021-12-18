package com.solvd.navigator.algorithm.impl.floydwarshall;

import com.solvd.navigator.algorithm.ShortestPathAlgorithm;
import com.solvd.navigator.domain.Point;
import com.solvd.navigator.domain.exception.InvalidParametersException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class FloydWarshallAlgorithm implements ShortestPathAlgorithm {

    private PairNodesMatrix matrix;

    public FloydWarshallAlgorithm(List<Point> points) {
        matrix = new PairNodesMatrix(points);
        matrix.countIndirectCosts();
    }

    @Override
    public Optional<Double> getPathLength(Point from, Point to) {
        Integer fromIndex = matrix.getIndex(from);
        Integer toIndex = matrix.getIndex(to);
        return Optional.of(matrix.getCost(fromIndex, toIndex));
    }

    @Override
    public Optional<List<Point>> getShortPath(Point from, Point to) throws InvalidParametersException {
        List<Point> path = new LinkedList<>();
        int fromIndex = matrix.getIndex(from);
        int toIndex = matrix.getIndex(to);
        if (fromIndex < 0 || toIndex < 0) {
            throw new InvalidParametersException("Error when try to get short path - there are no such points in matrix");
        }
        if (matrix.getAbility(fromIndex, toIndex) == -1) {
            return Optional.empty();
        }
        path.add(matrix.getNodeByIndex(fromIndex));
        while (fromIndex != toIndex) {
            fromIndex = matrix.getAbility(fromIndex, toIndex);
            path.add(matrix.getNodeByIndex(fromIndex));
        }
        return Optional.of(Collections.unmodifiableList(path));
    }

    public List<Point> getMatrixPoints() {
        return this.matrix.getPoints();
    }
}

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

    public FloydWarshallAlgorithm(List<Point> countryNodes) {
        matrix = new PairNodesMatrix(countryNodes);
        matrix.countIndirectCosts();
    }

    @Override
    public Optional<Double> getPathLength(Point a, Point b) {
        Integer aIndex = matrix.getIndex(a);
        Integer bIndex = matrix.getIndex(b);
        return Optional.of(matrix.getCost(aIndex, bIndex));
    }

    @Override
    public Optional<List<Point>> getShortPath(Point a, Point b) throws InvalidParametersException {
        List<Point> path = new LinkedList<>();
        int i = matrix.getIndex(a);
        int j = matrix.getIndex(b);
        if (i < 0 || j < 0) {
            throw new InvalidParametersException("Error when try to get short path");
        }
        if (matrix.getAbility(i, j) == -1) {
            return Optional.empty();
        }
        path.add(matrix.getNodeByIndex(i));
        while (i != j) {
            i = matrix.getAbility(i, j);
            path.add(matrix.getNodeByIndex(i));
        }
        return Optional.of(Collections.unmodifiableList(path));
    }

    public List<Point> getMatrixPoints() {
        return this.matrix.getNodes();
    }
}

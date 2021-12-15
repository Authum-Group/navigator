package com.solvd.navigator.algorithm.impl.floydwarshall;

import com.solvd.navigator.algorithm.ShortestPathAlgorithm;
import com.solvd.navigator.domain.Point;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class FloydWarshallAlgorithm implements ShortestPathAlgorithm {

    PairNodesMatrix matrix;

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
    public Optional<List<Point>> getShortPath(Point a, Point b) {
        List<Point> path = new LinkedList<>();
        int i = matrix.getIndex(a);
        int j = matrix.getIndex(b);
        if (matrix.getAbility(i, j) == -1) {
            return Optional.empty();
        }
        while (i != j) {
            i = matrix.getAbility(i, j);
            path.add(matrix.getNodeByIndex(i));
        }
        return Optional.of(Collections.unmodifiableList(path));
    }
}

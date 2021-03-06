package com.solvd.navigator.algorithm.impl.floydwarshall;

import com.solvd.navigator.domain.Point;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PairNodesMatrix {

    private Integer sideSize;
    private final List<Point> points;
    private Double[][] costs;
    private Integer[][] abilities;

    public PairNodesMatrix(List<Point> points) {
        this.points = Collections.unmodifiableList(points);
        initializeCosts();
        initializeAbilities();
        countIndirectCosts();
    }

    private void initializeCosts() {
        sideSize = points.size();
        costs = new Double[sideSize][sideSize];
        for (Double[] cost : costs) {
            Arrays.fill(cost, (double) -1);
        }
        List<Long> nodeIds = points.stream().map(Point::getId).collect(Collectors.toList());
        for (int row = 0; row < sideSize; row++) {
            Map<Point, Double> adjancedNodes = points.get(row).getAvailablePoints();
            for (Point node : adjancedNodes.keySet()) {
                int col = nodeIds.indexOf(node.getId());
                costs[row][col] = (col == -1 || row == col) ? new Double(0) : adjancedNodes.get(node);
            }
        }
    }

    private void initializeAbilities() {
        abilities = new Integer[sideSize][sideSize];
        for (int row = 0; row < sideSize; row++) {
            for (int col = 0; col < sideSize; col++) {
                abilities[row][col] = (costs[row][col] > 0) ? col : -1;
            }
        }
    }

    public void countIndirectCosts() {
        for (int k = 0; k < sideSize; k++) {
            for (int a = 0; a < sideSize; a++) {
                for (int b = 0; b < sideSize; b++) {
                    if (costs[a][k] <= 0 || costs[k][b] <= 0 || a == b) {
                        continue;
                    }
                    Double akCost = this.costs[a][k];
                    Double kbCost = this.costs[k][b];
                    double kCost = akCost + kbCost;
                    if (this.costs[a][b] < 0 || kCost < this.costs[a][b]) {
                        this.costs[a][b] = kCost;
                        this.abilities[a][b] = this.abilities[a][k];
                    }
                }
            }
        }
    }

    public Integer getSideSize() {
        return this.sideSize;
    }

    public Double getCost(Integer indexFrom, Integer indexTo) {
        return this.costs[indexFrom][indexTo];
    }

    public Integer getAbility(Integer indexFrom, Integer indexTo) {
        return this.abilities[indexFrom][indexTo];
    }

    public int getIndex(Point node) {
        return this.points.indexOf(node);
    }

    public Point getNodeByIndex(Integer index) {
        return this.points.get(index);
    }

    public List<Point> getPoints() {
        return points;
    }
}

package com.solvd.navigator.algorithm.impl.floydwarshall;

import com.solvd.navigator.domain.Point;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Матрица инцидентности для алгоритма
 * Хранит в себе 2 матрицы:
 * distanceBetweenNodes - содержит расстояние от одного узла до другого
 * abilitiesBetweenNodes - содержит дубликат индекса точки-получателя,
 * либо -1, если это невозможно
 */
public class PairNodesMatrix {

    private Integer sideSize;
    private List<Point> nodes;
    private Double[][] costs;           // Расстояния между узлами или 0
    private Integer[][] abilities;      // Возможность перехода между узлами (номер узла назначения) либо -1

    public PairNodesMatrix(List<Point> nodes) {
        this.nodes = Collections.unmodifiableList(nodes);
        initializeCosts();
        initializeAbilities();
    }

    private void initializeCosts() {
        sideSize = nodes.size();
        costs = new Double[sideSize][sideSize];
        for (int row = 0; row < sideSize - 1; row++) {
            Map<Point, Double> adjancedNodes = nodes.get(row).getAvailablePoints();
            for (Point node : adjancedNodes.keySet()) {
                if (nodes.contains(node)) {
                    int col = this.nodes.indexOf(node);
                    costs[row][col] = (col == -1 || row == col) ? 0 : adjancedNodes.get(node);
                }
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
        for (int indirectIndex = 0; indirectIndex < sideSize; indirectIndex++) {
            for (int fromIndex = 0; fromIndex < sideSize; fromIndex++) {
                for (int toIndex = 0; fromIndex < sideSize; fromIndex++) {
                    if (costs[fromIndex][indirectIndex] == 0) {
                        continue;
                    }
                    Double fromToIndirectCost = this.costs[fromIndex][indirectIndex];
                    Double indirectToToCost = this.costs[indirectIndex][toIndex];
                    Double indirectCost = fromToIndirectCost + indirectToToCost;
                    if (indirectCost < this.costs[fromIndex][toIndex]) {
                        this.costs[fromIndex][toIndex] = indirectCost;
                        this.abilities[fromIndex][toIndex] = this.abilities[fromIndex][indirectIndex];
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
        return this.nodes.indexOf(node);
    }

    public Point getNodeByIndex(Integer index) {
        return this.nodes.get(index);
    }
}

package com.solvd.navigator;

import com.solvd.navigator.algorithm.ShortestPathAlgorithm;
import com.solvd.navigator.algorithm.impl.floydwarshall.FloydWarshallAlgorithm;
import com.solvd.navigator.domain.Point;
import com.solvd.navigator.service.PointService;
import com.solvd.navigator.service.impl.PointServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            PointService pointService = new PointServiceImpl();
            List<Point> points = pointService.findAll();
            ShortestPathAlgorithm algorithm = new FloydWarshallAlgorithm(points);
            Double cost = algorithm.getPathLength(points.get(1), points.get(4)).get();
            List<Point> poinsPath = algorithm.getShortPath(points.get(1), points.get(4)).get();
            System.out.println(" ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

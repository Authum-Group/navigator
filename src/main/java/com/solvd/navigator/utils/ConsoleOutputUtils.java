package com.solvd.navigator.utils;


import com.solvd.navigator.algorithm.ShortestPathAlgorithm;
import com.solvd.navigator.algorithm.impl.floydwarshall.FloydWarshallAlgorithm;
import com.solvd.navigator.domain.Point;
import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;
import com.solvd.navigator.service.PointService;
import com.solvd.navigator.service.impl.PointServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleOutputUtils {

    private static final Logger LOGGER = LogManager.getLogger(ConsoleOutputUtils.class);

    private Point a;
    private Point b;
    private String pointName;
    private PointService pointService;
    private List<Point> points;
    private ShortestPathAlgorithm shortestPathAlgorithm;
    Scanner scanner;

    public ConsoleOutputUtils() {
        try {
            this.pointService = new PointServiceImpl();
            this.points = pointService.findAll();
            this.shortestPathAlgorithm = new FloydWarshallAlgorithm(points);
            scanner = new Scanner(System.in);
        } catch (ResourceNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        System.out.println("+------------------------------------------------------------------------+\n" +
                "|                  Hello! Welcome to the Navigator v1.0                  |\n" +
                "+------------------------------------------------------------------------+\n" +
                "| The application provides the ability to calculate the minimum distance |\n" +
                "| between map objects (houses, sports facilities, road sections, etc.).  |\n" +
                "| A partial match is available.                                          |\n" +
                "| Press enter to continue                                                |\n" +
                "+------------------------------------------------------------------------+\n");

        scanner.nextLine();
    }

    public void getStartPoint() {
        String lastString = "";
        while (true) {
            System.out.println("+---------------------------+\n" +
                    "| Enter the starting point. |\n" +
                    "+---------------------------+\n");
            lastString = scanner.nextLine();
            String finalLastString = lastString;
            List<Point> possiblePoints = shortestPathAlgorithm.getMatrixPoints().stream()
                    .filter(point -> {
                        return point.toString().toLowerCase(Locale.ROOT).contains(finalLastString.toLowerCase(Locale.ROOT));
                    }).limit(5)
                    .collect(Collectors.toList());
            if (possiblePoints.size() == 1 && possiblePoints.get(0).toString().toLowerCase(Locale.ROOT).trim().equals(finalLastString.toLowerCase(Locale.ROOT).trim())) {
                a = possiblePoints.get(0);
                return;
            }
            if (possiblePoints.size() > 0) {
                System.out.println("+-----------------+\n" +
                        "| Possible points |\n" +
                        "+-----------------+\n");
                for (Point point : possiblePoints) {
                    System.out.println(point.toString() + "\n");
                }
            }
            System.out.println("+--------------------------------+\n" +
                    "| your previous input was wrong! |\n" +
                    "+--------------------------------+\n");
            System.out.flush();
        }
    }

    public void getFinishPoint() {
        String lastString = "";
        while (true) {
            System.out.println("+---------------------------+\n" +
                    "| Enter the finish point. |\n" +
                    "+---------------------------+\n");
            System.out.flush();
            lastString = scanner.nextLine();
            String finalLastString = lastString;
            List<Point> possiblePoints = shortestPathAlgorithm.getMatrixPoints().stream()
                    .filter(point -> {
                        return point.toString().toLowerCase(Locale.ROOT).contains(finalLastString.toLowerCase(Locale.ROOT));
                    }).limit(5)
                    .collect(Collectors.toList());
            if (possiblePoints.size() == 1 && possiblePoints.get(0).toString().toLowerCase(Locale.ROOT).equals(finalLastString.toLowerCase(Locale.ROOT))) {
                b = possiblePoints.get(0);
                return;
            }
            if (possiblePoints.size() > 0) {
                System.out.println("+-----------------+\n" +
                        "| Possible points |\n" +
                        "+-----------------+\n");
                for (Point point : possiblePoints) {
                    System.out.println(point.toString() + "\n");
                }
            }
            System.out.println("+--------------------------------+\n" +
                    "| your previous input was wrong! |\n" +
                    "+--------------------------------+\n");
            System.out.flush();
        }
    }

    public void showShortestPath() throws InvalidParametersException {
        System.out.println("+------------------+\n" +
                "| Recommended path |\n" +
                "+------------------+");
        List<Point> points = shortestPathAlgorithm.getShortPath(a, b).orElse(null);
        if (points == null) {
            System.out.println("+-------------------------------------+\n" +
                    "| There is no path between the points |\n" +
                    "+-------------------------------------+\n");
        } else {
            for (Point point : points) {
                System.out.println("\t" + point.toString() + "\n\n");
            }
            System.out.println(String.format("RESULT PATH COST: %s km. \n", shortestPathAlgorithm.getPathLength(a, b).get()));
        }
        System.out.println("PRESS ENTER KEY TO CLOSE APP\n");
        scanner.nextLine();
        System.exit(0);
    }
}

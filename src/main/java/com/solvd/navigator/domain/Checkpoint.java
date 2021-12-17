package com.solvd.navigator.domain;

public class Checkpoint {

    private static final Logger LOGGER = LogManager.getLogger(Checkpoint.class);

    private Point a;
    private point b;
    private String pointName;
    private PointService pointService;
    private FloydWarshallAlgorithm floydWarshallAlgorithm;

    public Checkpoint() {
        this.pointService = new PointServiceImpl();
        this.floydWarshallAlgorithm = new FloydWarshallAlgorithm();
    }

    public void getStartPoint() {
        LOGGER.info("Hello! Please, enter the address of the route start point :");
        Scanner scanner = new Scanner(System.in);
        pointName = scanner.nextLine();
        List<Point> points = pointService.findAll();
        for (int i = 0; i < points.size(); i++) {
            while (points.get(i).toString != pointName) {
                if (points.get(i).toString = pointName) {
                    a = points.get(i);
                    LOGGER.info("Start point was found successfully.");
                }
            }
        }
    }

    public void getFinishPoint() {
        LOGGER.info("Enter destination : ");
        Scanner scanner = new Scanner(System.in);
        pointName = scanner.nextLine();
        List<Point> points = pointService.findAll();
        for (int i = 0; i < points.size(); i++) {
            while (points.get(i).toString != pointName) {
                if (points.get(i).toString = pointName) {
                    a = points.get(i);
                    LOGGER.info("Finish point was found successfully.");
                }
            }
        }
    }

        LOGGER.info("Length your way : " + floydWarshallAlgorithm.getPathLength(Point a, Point b));
        LOGGER.info("Shortest path: : " + floydWarshallAlgorithm.getShortPath(Point a, Point b));
    }
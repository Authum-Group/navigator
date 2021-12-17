package com.solvd.navigator.domain;

public class Checkpoint {

    private static final Logger LOGGER = LogManager.getLogger(Checkpoint.class);

    private Point a;
    private point b;
    private PointService pointService;
    private FloydWarshallAlgorithm floydWarshallAlgorithm;

    public Checkpoint(){
        this.pointService = new PointServiceImpl();
        this.floydWarshallAlgorithm = new FloydWarshallAlgorithm();
    }

    public void getStartPoint() {
        LOGGER.info("Hello! Please, enter the address of the route start point :");
        Scanner scanner = new Scanner(System.in);
        String pointName = scanner.nextLine();
        Long idI = pointService.getIdByName(pointName);
        a = pointService.findById(idI);
    }

    public void getFinishPoint() {
        LOGGER.info("Enter Destination :");
        pointName = scanner.nextLine();
        Long idJ = pointService.getIdByName(pointName);
        b = pointService.findById(idJ);
    }

    LOGGER.info("Length your way : " + floydWarshallAlgorithm.getPathLength(Point a, Point b));
    LOGGER.info("Shortest path: : " + floydWarshallAlgorithm.getShortPath(Point a, Point b));
}
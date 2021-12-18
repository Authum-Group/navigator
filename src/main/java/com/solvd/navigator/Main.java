package com.solvd.navigator;

import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.utils.ConsoleOutputUtils;

public class Main {

    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            ConsoleOutputUtils outputUtils = new ConsoleOutputUtils();
            outputUtils.getStartPoint();
            outputUtils.getFinishPoint();
            outputUtils.showShortestPath();
        } catch (InvalidParametersException e) {
            e.printStackTrace();
        }

      //  DataBaseInitialization.initialize();

    }
}

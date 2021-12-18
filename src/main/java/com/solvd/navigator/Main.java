package com.solvd.navigator;

import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.utils.ConsoleOutputUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            ConsoleOutputUtils outputUtils = new ConsoleOutputUtils();
            outputUtils.getStartPoint();
            outputUtils.getFinishPoint();
            outputUtils.showShortestPath();
        } catch (InvalidParametersException e) {
            LOGGER.error("Invalid parameters when try to show shortest path");
        }

        //  DataBaseInitialization.initialize();

    }
}

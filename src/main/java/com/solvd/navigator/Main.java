package com.solvd.navigator;

import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.utils.ConsoleOutputUtils;

public class Main {

    public static void main(String[] args) throws InvalidParametersException {
        ConsoleOutputUtils outputUtils = new ConsoleOutputUtils();
        outputUtils.getStartPoint();
        outputUtils.getFinishPoint();
        outputUtils.showShortestPath();
    }
}

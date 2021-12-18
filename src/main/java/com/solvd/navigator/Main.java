package com.solvd.navigator;

import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.utils.ConsoleOutputUtils;
import com.solvd.navigator.domain.*;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;
import com.solvd.navigator.domain.exception.EntityIsNotValidException;
import com.solvd.navigator.service.*;
import com.solvd.navigator.service.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

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

        DataBaseInitialization.initialize();

    }
}
package com.solvd.navigator.service;

import com.solvd.navigator.domain.Transition;
import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;
import com.solvd.navigator.domain.exception.ValidationException;

import java.util.List;

public interface TransitionService {

    void create(Transition transition) throws InvalidParametersException, ValidationException;

    List<Transition> findAll() throws ResourceNotFoundException;

    Transition findById(Long id) throws InvalidParametersException, ResourceNotFoundException;

    void update(Transition transition) throws InvalidParametersException, ValidationException, ResourceNotFoundException;

    void delete(Transition transition) throws InvalidParametersException, ResourceNotFoundException;
}

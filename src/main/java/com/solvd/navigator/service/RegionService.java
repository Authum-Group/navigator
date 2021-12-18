package com.solvd.navigator.service;

import com.solvd.navigator.domain.Region;
import com.solvd.navigator.domain.exception.EntityNotValidException;
import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;

import java.util.List;

public interface RegionService {
    void create(Region region, Long countryId) throws InvalidParametersException, EntityNotValidException, ResourceNotFoundException;

    List<Region> findAll() throws ResourceNotFoundException;

    Region findById(Long id) throws InvalidParametersException, ResourceNotFoundException;

    void update(Region region) throws InvalidParametersException, EntityNotValidException, ResourceNotFoundException;

    void delete(Region region) throws InvalidParametersException, ResourceNotFoundException;
}

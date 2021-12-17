package com.solvd.navigator.service.impl;

import com.solvd.navigator.domain.City;
import com.solvd.navigator.domain.Region;
import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;
import com.solvd.navigator.domain.exception.ValidationException;
import com.solvd.navigator.persistence.RegionRepository;
import com.solvd.navigator.persistence.mybatisImpl.RegionRepositoryMyBatisImpl;
import com.solvd.navigator.service.CityService;
import com.solvd.navigator.service.RegionService;

import java.util.List;
import java.util.stream.Collectors;

public class RegionServiceImpl implements RegionService {

    private static final RegionRepository REGION_REPOSITORY = new RegionRepositoryMyBatisImpl();
    private static final CityService CITY_SERVICE = new CityServiceImpl();
    private static final String exceptionStub = "Exception when try to %s Region - %s";

    @Override
    public void create(Region region) throws InvalidParametersException, ValidationException {
        if (region == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "create", "region's object is null"));
        }
        if (!isValid(region)) {
            throw new ValidationException(String.format(exceptionStub, "create", "region's object is not valid"));
        }
        region.setId(null);
        REGION_REPOSITORY.create(region);

        for (City city : region.getCities()) {
            CITY_SERVICE.create(city);
        }
    }

    @Override
    public List<Region> findAll() throws ResourceNotFoundException {
        List<Region> regions = REGION_REPOSITORY.findAll();

        List<City> cities = CITY_SERVICE.findAll(); // TODO Optimization
        for (Region region : regions) {
            region.setCities(cities.stream()
                    .filter(city -> region.getId().equals(city.getRegion().getId()))
                    .collect(Collectors.toList()));
        }
        return regions;
    }

    @Override
    public Region findById(Long id) throws InvalidParametersException, ResourceNotFoundException {
        if (id == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "find by id", "id is null"));
        }
        Region region = REGION_REPOSITORY.findById(id);
        if (region == null) {
            throw new ResourceNotFoundException(String.format(exceptionStub, "find by id", "there are no region with id=" + id));
        }
        region.setCities(CITY_SERVICE.findAll().stream()
                .filter(city -> id.equals(city.getRegion().getId()))
                .collect(Collectors.toList())
        );
        return region;
    }

    @Override
    public void update(Region region) throws InvalidParametersException, ValidationException, ResourceNotFoundException {
        if (region == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "update", "region's object is null"));
        }
        if (region.getId() == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "update", "region's id is null"));
        }
        if (!isValid(region)) {
            throw new ValidationException(String.format(exceptionStub, "update", "region's object is not valid"));
        }
        findById(region.getId()); // TODO Change way to check object in db
        REGION_REPOSITORY.update(region);

        for (City city : region.getCities()) {
            if (!city.equals(CITY_SERVICE.findById(city.getId()))) {
                CITY_SERVICE.update(city);
            }
        }
    }

    @Override
    public void delete(Region region) throws InvalidParametersException, ResourceNotFoundException {
        if (region == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "delete", "region's object is null"));
        }
        if (region.getId() == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "delete", "region object's id is null"));
        }
        findById(region.getId());
        REGION_REPOSITORY.delete(region);
    }

    private boolean isValid(Region region) {
        return region.getName() != null && region.getCountry() != null;
    }
}
package com.solvd.navigator.service.impl;

import com.solvd.navigator.domain.City;
import com.solvd.navigator.domain.District;
import com.solvd.navigator.domain.Street;
import com.solvd.navigator.domain.exception.EntityNotValidException;
import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;
import com.solvd.navigator.persistence.DistrictRepository;
import com.solvd.navigator.persistence.mybatisImpl.DistrictRepositoryMyBatisImpl;
import com.solvd.navigator.service.CityService;
import com.solvd.navigator.service.DistrictService;
import com.solvd.navigator.service.StreetService;

import java.util.List;
import java.util.stream.Collectors;

public class DistrictServiceImpl implements DistrictService {

    private static final DistrictRepository DISTRICT_REPOSITORY = new DistrictRepositoryMyBatisImpl();
    private static final StreetService STREET_SERVICE = new StreetServiceImpl();
    private static final CityService CITY_SERVICE = new CityServiceImpl();
    private static final String exceptionStub = "Exception when try to %s District - %s";

    @Override
    public void create(District district, Long cityId) throws InvalidParametersException, EntityNotValidException, ResourceNotFoundException {
        if (district == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "create", "district's object is null"));
        }
        if (!isValid(district)) {
            throw new EntityNotValidException(String.format(exceptionStub, "create", "district object is not valid"));
        }
        district.setId(null);
        City city = null;
        if (cityId != null) {
            city = CITY_SERVICE.findById(cityId);
        }
        district.setCity(city);
        DISTRICT_REPOSITORY.create(district);
        if (district.getStreets() == null) {
            return;
        }
        for (Street districtStreet : district.getStreets()) {
            STREET_SERVICE.create(districtStreet, district.getId());
        }
    }

    @Override
    public List<District> findAll() throws ResourceNotFoundException {
        List<District> districts = DISTRICT_REPOSITORY.findAll();
        List<Street> streets = STREET_SERVICE.findAll();
        for (District district : districts) {
            district.setStreets(streets.stream()
                    .filter(street -> street.getDistrict().getId().equals(district.getId()))
                    .collect(Collectors.toList())
            );
        }
        return districts;
    }

    @Override
    public District findById(Long id) throws InvalidParametersException, ResourceNotFoundException {
        if (id == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "find by id", "id is null"));
        }
        District district = DISTRICT_REPOSITORY.findById(id);
        if (district == null) {
            throw new ResourceNotFoundException(String.format(exceptionStub, "find by id", "there are no district with id=" + id));
        }

        district.setStreets(STREET_SERVICE.findAll().stream()
                .filter(street -> id.equals(street.getDistrict().getId()))
                .collect(Collectors.toList()));
        return district;
    }

    @Override
    public void update(District district) throws InvalidParametersException, EntityNotValidException, ResourceNotFoundException {
        if (district == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "update", "district's object is null"));
        }
        if (district.getId() == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "update", "district's id is null"));
        }
        if (!isValid(district)) {
            throw new EntityNotValidException(String.format(exceptionStub, "update", "district's object is not valid"));
        }
        findById(district.getId());
        DISTRICT_REPOSITORY.update(district);

        for (Street street : district.getStreets()) {
            if (!street.equals(STREET_SERVICE.findById(street.getId()))) {
                STREET_SERVICE.update(street);
            }
        }
    }

    @Override
    public void delete(District district) throws InvalidParametersException, ResourceNotFoundException {
        if (district == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "delete", "district's object is null"));
        }
        if (district.getId() == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "delete", "district object's id is null"));
        }
        findById(district.getId());
        DISTRICT_REPOSITORY.delete(district);
    }

    private boolean isValid(District district) {
        return district.getName() != null && district.getCity() != null;
    }
}

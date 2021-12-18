package com.solvd.navigator.service.impl;

import com.solvd.navigator.domain.PointType;
import com.solvd.navigator.domain.exception.EntityNotValidException;
import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;
import com.solvd.navigator.persistence.PointTypeRepository;
import com.solvd.navigator.persistence.mybatisImpl.PointTypeRepositoryMyBatisImpl;
import com.solvd.navigator.service.PointTypeService;

import java.util.List;

public class PointTypeServiceImpl implements PointTypeService {

    private static final PointTypeRepository POINT_TYPE_REPOSITORY = new PointTypeRepositoryMyBatisImpl();
    private static final String exceptionStub = "Exception when try to %s PointType - %s";

    @Override
    public void create(PointType pointType) throws EntityNotValidException, InvalidParametersException, ResourceNotFoundException {
        if (pointType == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "create", "point type's object is null"));
        }
        if (!isValid(pointType)) {
            throw new EntityNotValidException(String.format(exceptionStub, "create", "point type's object is not valid"));
        }
        pointType.setId(null);
        POINT_TYPE_REPOSITORY.create(pointType);
    }

    @Override
    public List<PointType> findAll() throws ResourceNotFoundException {
        List<PointType> pointTypes = POINT_TYPE_REPOSITORY.findAll();
        return pointTypes;
    }

    @Override
    public PointType findById(Long id) throws InvalidParametersException, ResourceNotFoundException {
        if (id == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "find by id", "id is null"));
        }
        PointType pointType = POINT_TYPE_REPOSITORY.findById(id);
        if (pointType == null) {
            throw new ResourceNotFoundException(String.format(exceptionStub, "find by id", "there are no point type with id=" + id));
        }
        return pointType;
    }

    @Override
    public void update(PointType pointType) throws InvalidParametersException, ResourceNotFoundException, EntityNotValidException {
        if (pointType == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "update", "point type's object is null"));
        }
        if (pointType.getId() == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "update", "point type's id is null"));
        }
        if (!isValid(pointType)) {
            throw new EntityNotValidException(String.format(exceptionStub, "update", "point type's object is not valid"));
        }
        findById(pointType.getId());
        POINT_TYPE_REPOSITORY.update(pointType);
    }

    @Override
    public void delete(PointType pointType) throws InvalidParametersException, ResourceNotFoundException {
        if (pointType == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "delete", "point type's object is null"));
        }
        if (pointType.getId() == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "delete", "point type object's id is null"));
        }
        findById(pointType.getId());
        POINT_TYPE_REPOSITORY.delete(pointType);
    }

    private boolean isValid(PointType pointType) {
        return pointType.getName() != null;
    }
}

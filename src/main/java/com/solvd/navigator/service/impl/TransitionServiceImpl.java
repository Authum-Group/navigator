package com.solvd.navigator.service.impl;

import com.solvd.navigator.domain.Transition;
import com.solvd.navigator.domain.exception.EntityIsNotValidException;
import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;
import com.solvd.navigator.persistence.TransitionRepository;
import com.solvd.navigator.persistence.mybatisImpl.TransitionRepositoryMyBatisImpl;
import com.solvd.navigator.service.PointService;
import com.solvd.navigator.service.TransitionService;

import java.util.List;

public class TransitionServiceImpl implements TransitionService {

    private static final TransitionRepository TRANSITION_REPOSITORY = new TransitionRepositoryMyBatisImpl();
    private static final PointService POINT_SERVICE = new PointServiceImpl();
    private static final String exceptionStub = "Exception when try to %s Transitions - %s";

    @Override
    public void create(Transition transition) throws InvalidParametersException, EntityIsNotValidException {
        if (transition == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "create", "transition's object is null"));
        }
        if (!isValid(transition)) {
            throw new EntityIsNotValidException(String.format(exceptionStub, "create", "transition's object is not valid"));
        }
        transition.setId(null);
        TRANSITION_REPOSITORY.create(transition);
    }

    @Override
    public List<Transition> findAll() throws ResourceNotFoundException {
        return TRANSITION_REPOSITORY.findAll();
    }

    @Override
    public Transition findById(Long id) throws InvalidParametersException, ResourceNotFoundException {
        if (id == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "find by id", "id is null"));
        }
        Transition transition = TRANSITION_REPOSITORY.findById(id);
        if (transition == null) {
            throw new ResourceNotFoundException(String.format(exceptionStub, "find by id", "there are no transition with id=" + id));
        }
        return transition;
    }

    @Override
    public void update(Transition transition) throws InvalidParametersException, EntityIsNotValidException, ResourceNotFoundException {
        if (transition == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "update", "transition's object is null"));
        }
        if (transition.getId() == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "update", "transition's id is null"));
        }
        if (!isValid(transition)) {
            throw new EntityIsNotValidException(String.format(exceptionStub, "update", "transition's object is not valid"));
        }
        findById(transition.getId());
        TRANSITION_REPOSITORY.update(transition);
    }

    @Override
    public void delete(Transition transition) throws InvalidParametersException, ResourceNotFoundException {
        if (transition == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "delete", "transition's object is null"));
        }
        if (transition.getId() == null) {
            throw new InvalidParametersException(String.format(exceptionStub, "delete", "transition object's id is null"));
        }
        findById(transition.getId());
        TRANSITION_REPOSITORY.delete(transition);
    }

    private boolean isValid(Transition transition) {
        return transition.getFrom() != null && transition.getTo() != null;
    }
}

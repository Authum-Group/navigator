package com.solvd.navigator.persistence;

import com.solvd.navigator.domain.Transition;

import java.util.List;

public interface TransitionRepository {

    void create(Transition transition);

    List<Transition> findAll();

    Transition findById(Long id);

    void update(Transition transition);

    void delete(Transition transition);
}

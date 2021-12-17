package com.solvd.navigator.persistence;

import com.solvd.navigator.domain.PointType;

import java.util.List;

public interface PointTypeRepository {

    void create(PointType type);

    List<PointType> findAll();

    PointType findById(Long id);

    void update(PointType type);

    void delete(PointType type);
}

package com.solvd.navigator.persistence;

import com.solvd.navigator.domain.District;

import java.util.List;

public interface DistrictRepository {

    void create(District district);

    List<District> findAll();

    District findById(Long id);

    void update(District district);

    void delete(District district);
}

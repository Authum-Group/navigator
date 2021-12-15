package com.solvd.navigator.persistence;

import com.solvd.navigator.domain.Region;

import java.util.List;

public interface RegionRepository {

    void create(Region region);

    List<Region> findAll();

    Region findById(Long id);

    void update(Region region);

    void delete(Region region);

}

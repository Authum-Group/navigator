package com.solvd.navigator.service.impl;

import com.solvd.navigator.persistence.PointRepository;
import com.solvd.navigator.service.PointService;

public class PointServiceImpl implements PointService {

    @Override
    public Long getIdByName(String point1) throws Exception {
        return PointRepository.findIdByName(point1)
                .orElseThrow(() -> new Exception("No point with this name"));
    }
}

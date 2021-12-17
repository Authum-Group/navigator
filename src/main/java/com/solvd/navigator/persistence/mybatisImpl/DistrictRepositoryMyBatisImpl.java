package com.solvd.navigator.persistence.mybatisImpl;

import com.solvd.navigator.domain.District;
import com.solvd.navigator.persistence.DistrictRepository;
import com.solvd.navigator.persistence.MyBatisSessionHolder;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DistrictRepositoryMyBatisImpl implements DistrictRepository {

    @Override
    public void create(District district) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            DistrictRepository districtRepository = session.getMapper(DistrictRepository.class);
            districtRepository.create(district);
        }
    }

    @Override
    public List<District> findAll() {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            DistrictRepository districtRepository = session.getMapper(DistrictRepository.class);
            return districtRepository.findAll();
        }
    }

    @Override
    public District findById(Long id) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            DistrictRepository districtRepository = session.getMapper(DistrictRepository.class);
            return districtRepository.findById(id);
        }
    }

    @Override
    public void update(District district) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            DistrictRepository districtRepository = session.getMapper(DistrictRepository.class);
            districtRepository.update(district);
        }
    }

    @Override
    public void delete(District district) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            DistrictRepository districtRepository = session.getMapper(DistrictRepository.class);
            districtRepository.delete(district);
        }
    }
}

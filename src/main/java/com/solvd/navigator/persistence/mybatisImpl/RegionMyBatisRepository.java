package com.solvd.navigator.persistence.mybatisImpl;

import com.solvd.navigator.domain.Region;
import com.solvd.navigator.persistence.MyBatisSessionHolder;
import com.solvd.navigator.persistence.RegionRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RegionMyBatisRepository implements RegionRepository {

    @Override
    public void create(Region region) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            RegionRepository regionRepository = session.getMapper(RegionRepository.class);
            regionRepository.create(region);
        }
    }

    @Override
    public List<Region> findAll() {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            RegionRepository regionRepository = session.getMapper(RegionRepository.class);
            return regionRepository.findAll();
        }
    }

    @Override
    public Region findById(Long id) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            RegionRepository regionRepository = session.getMapper(RegionRepository.class);
            return regionRepository.findById(id);
        }
    }

    @Override
    public void update(Region region) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            RegionRepository regionRepository = session.getMapper(RegionRepository.class);
            regionRepository.update(region);
        }
    }

    @Override
    public void delete(Region region) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            RegionRepository regionRepository = session.getMapper(RegionRepository.class);
            regionRepository.delete(region);
        }
    }

}

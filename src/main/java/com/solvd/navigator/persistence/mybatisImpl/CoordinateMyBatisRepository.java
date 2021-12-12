package com.solvd.navigator.persistence.mybatisImpl;

import com.solvd.navigator.domain.Coordinate;
import com.solvd.navigator.persistence.CoordinateRepository;
import com.solvd.navigator.persistence.MyBatisSessionHolder;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CoordinateMyBatisRepository implements CoordinateRepository {

    @Override
    public void create(Coordinate coordinate) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            CoordinateRepository coordinateRepository = session.getMapper(CoordinateRepository.class);
            coordinateRepository.create(coordinate);
        }
    }

    @Override
    public List<Coordinate> findAll() {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            CoordinateRepository coordinateRepository = session.getMapper(CoordinateRepository.class);
            return coordinateRepository.findAll();
        }
    }

    @Override
    public Coordinate findById(Long id) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            CoordinateRepository coordinateRepository = session.getMapper(CoordinateRepository.class);
            return coordinateRepository.findById(id);
        }
    }

    @Override
    public void update(Coordinate coordinate) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            CoordinateRepository coordinateRepository = session.getMapper(CoordinateRepository.class);
            coordinateRepository.update(coordinate);
        }
    }

    @Override
    public void delete(Coordinate coordinate) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            CoordinateRepository coordinateRepository = session.getMapper(CoordinateRepository.class);
            coordinateRepository.delete(coordinate);
        }

    }
}

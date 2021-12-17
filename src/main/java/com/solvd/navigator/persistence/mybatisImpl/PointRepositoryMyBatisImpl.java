package com.solvd.navigator.persistence.mybatisImpl;

import com.solvd.navigator.domain.Point;
import com.solvd.navigator.persistence.MyBatisSessionHolder;
import com.solvd.navigator.persistence.PointRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PointRepositoryMyBatisImpl implements PointRepository {

    @Override
    public void create(Point point) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            PointRepository pointRepository = session.getMapper(PointRepository.class);
            pointRepository.create(point);
        }
    }

    @Override
    public List<Point> findAll() {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            PointRepository pointRepository = session.getMapper(PointRepository.class);
            return pointRepository.findAll();
        }
    }

    @Override
    public Point findById(Long id) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            PointRepository pointRepository = session.getMapper(PointRepository.class);
            return pointRepository.findById(id);
        }
    }

    @Override
    public void update(Point point) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            PointRepository pointRepository = session.getMapper(PointRepository.class);
            pointRepository.update(point);
        }
    }

    @Override
    public void delete(Point point) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            PointRepository pointRepository = session.getMapper(PointRepository.class);
            pointRepository.delete(point);
        }
    }

    @Override
    public Optional<Long> findIdByName(String pointName) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            PointRepository pointRepository = session.getMapper(PointRepository.class);
            return pointRepository.findIdByName(id);
        }
    }
}

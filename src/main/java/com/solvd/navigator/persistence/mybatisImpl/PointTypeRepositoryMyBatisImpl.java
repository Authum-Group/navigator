package com.solvd.navigator.persistence.mybatisImpl;

import com.solvd.navigator.domain.PointType;
import com.solvd.navigator.persistence.MyBatisSessionHolder;
import com.solvd.navigator.persistence.PointTypeRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PointTypeRepositoryMyBatisImpl implements PointTypeRepository {
    @Override
    public void create(PointType type) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            PointTypeRepository pointTypeRepository = session.getMapper(PointTypeRepository.class);
            pointTypeRepository.create(type);
        }
    }

    @Override
    public List<PointType> findAll() {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            PointTypeRepository pointTypeRepository = session.getMapper(PointTypeRepository.class);
            return pointTypeRepository.findAll();
        }
    }

    @Override
    public PointType findById(Long id) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            PointTypeRepository pointTypeRepository = session.getMapper(PointTypeRepository.class);
            return pointTypeRepository.findById(id);
        }
    }

    @Override
    public void update(PointType type) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            PointTypeRepository pointTypeRepository = session.getMapper(PointTypeRepository.class);
            pointTypeRepository.update(type);
        }
    }

    @Override
    public void delete(PointType type) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            PointTypeRepository pointTypeRepository = session.getMapper(PointTypeRepository.class);
            pointTypeRepository.delete(type);
        }
    }
}

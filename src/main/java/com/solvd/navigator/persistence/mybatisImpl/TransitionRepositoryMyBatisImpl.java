package com.solvd.navigator.persistence.mybatisImpl;

import com.solvd.navigator.domain.Transition;
import com.solvd.navigator.persistence.MyBatisSessionHolder;
import com.solvd.navigator.persistence.TransitionRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TransitionRepositoryMyBatisImpl implements TransitionRepository {
    @Override
    public void create(Transition transition) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            TransitionRepository transitionRepository = session.getMapper(TransitionRepository.class);
            transitionRepository.create(transition);
        }
    }

    @Override
    public List<Transition> findAll() {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            TransitionRepository transitionRepository = session.getMapper(TransitionRepository.class);
            return transitionRepository.findAll();
        }
    }

    @Override
    public Transition findById(Long id) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            TransitionRepository transitionRepository = session.getMapper(TransitionRepository.class);
            return transitionRepository.findById(id);
        }
    }

    @Override
    public void update(Transition transition) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            TransitionRepository transitionRepository = session.getMapper(TransitionRepository.class);
            transitionRepository.update(transition);
        }
    }

    @Override
    public void delete(Transition transition) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            TransitionRepository transitionRepository = session.getMapper(TransitionRepository.class);
            transitionRepository.delete(transition);
        }
    }
}

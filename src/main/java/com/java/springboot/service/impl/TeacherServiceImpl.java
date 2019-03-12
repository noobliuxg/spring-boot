package com.java.springboot.service.impl;

import com.java.springboot.dao.TeacherDao;
import com.java.springboot.entity.Teacher;
import com.java.springboot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = "teachers")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> findAll() {
        return teacherDao.findAll();
    }

    @Transactional
    @CachePut(key = "#p0.id")
    @Override
    public Teacher update(Teacher teacher) {
        System.out.println("call update method");
        return teacherDao.save(teacher);
    }

    @Transactional
    @CacheEvict(key = "#p0")
    @Override
    public Teacher delete(Long id) {
        Optional<Teacher> optional = teacherDao.findOne((Specification<Teacher>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id").as(Long.class), id));
        Teacher teacher = optional.get();
        teacherDao.delete(teacher);
        return teacher;
    }

    @Cacheable(key = "#p0")
    @Override
    public Teacher findOne(Long id) {
        System.out.println("call findOne method");
        return teacherDao.findById(id).get();
    }
}

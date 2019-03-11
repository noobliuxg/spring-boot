package com.java.springboot.service.impl;

import com.java.springboot.dao.StudentDao;
import com.java.springboot.entity.Student;
import com.java.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Cacheable(value = "students")
    @Override
    public Student findOne(long id) {
        Student student = studentDao.findStudent(id);
        System.out.println(student);
        return student;
    }
}

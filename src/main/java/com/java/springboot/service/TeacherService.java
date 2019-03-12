package com.java.springboot.service;

import com.java.springboot.entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAll();

    Teacher update(Teacher teacher);

    Teacher delete(Long id);

    Teacher findOne(Long id);
}

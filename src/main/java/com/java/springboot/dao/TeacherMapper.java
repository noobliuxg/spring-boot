package com.java.springboot.dao;


import com.java.springboot.entity.Teacher;

import java.util.List;

public interface TeacherMapper {

    int insert(Teacher teacher);

    List<Teacher> selectAll();

    Teacher selectOne(long id);

    List<Teacher> selectWhere(Teacher teacher);

    int update(Teacher teacher);

    int delete(long id);
}

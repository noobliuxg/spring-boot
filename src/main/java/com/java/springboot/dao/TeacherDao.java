package com.java.springboot.dao;


import com.java.springboot.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherDao extends JpaSpecificationExecutor<Teacher>, JpaRepository<Teacher,Long> {

}

package com.java.springboot.dao;

import com.java.springboot.Application;
import com.java.springboot.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TeacherDaoTest {

    @Resource
    private TeacherDao teacherMapper;


    @Test
    public void selectAll(){

        Specification<Teacher> specification = new Specification<Teacher>() {
            @Override
            public Predicate toPredicate(Root<Teacher> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("teaName").as(String.class),"%liuxg%");
            }
        };
        List<Teacher> teachers = teacherMapper.findAll(specification);

        teachers.forEach(teacher -> {
            System.out.println(teacher);
        });
        System.out.println("排序后的输出");
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        teachers = teacherMapper.findAll(specification,sort);

        teachers.forEach(teacher -> {
            System.out.println(teacher);
        });

        System.out.println("分页-------------");
        Page<Teacher> page = teacherMapper.findAll(specification, PageRequest.of(1, 10));
        page.forEach(teacher -> {
            System.out.println(teacher);
        });
        System.out.println("分页加排序-------------");
        page = teacherMapper.findAll(specification, PageRequest.of(0, 10,Sort.by(Sort.Direction.DESC,"id")));
        page.forEach(teacher -> {
            System.out.println(teacher);
        });
    }

    @Test
    public void selectOne(){
    }

    @Test
    public void selectWhere(){
    }


    @Test
    public void update(){
    }


}

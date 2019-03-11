package com.java.springboot.dao;


import com.java.springboot.Application;
import com.java.springboot.entity.Student;
import org.hibernate.criterion.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserDaoTest {

    @Resource
    private StudentDao dao;

    @Test
    public void testInsert(){
        Student student = new Student();
        Student save = dao.save(student);
        System.out.println(save);
    }

    @Test
    public void testUpate(){
        Optional<Student> optional = dao.findById(27l);
        Student student = optional.get();
        student.setStuName("liu");
        dao.save(student);
    }


    @Transactional
    @Test
    public void testSelectOne(){
        Student student = dao.getOne(27l);
        System.out.println(student);

    }


    @Transactional
    @Test
    public void testSelectOneByExample(){
        Student student = new Student();
        student.setId(27l);
        Example<Student> example = Example.of(student);
        Optional<Student> optional = dao.findOne(Example.of(student));
        student = optional.get();
        System.out.println(student);
    }

    @Test
    public void testQuery1(){
        Student student = dao.findStudent(1l);
        System.out.println(student);
    }

    @Test
    public void testQuery2(){
        List<Student> students = dao.findAllStudent();
        students.forEach(student -> {
            System.out.println(student);
        });
    }

    @Test
    public void testQuery3(){
        List<Student> students = dao.findStudentByExample("%liu%",12);
        students.forEach(student -> {
            System.out.println(student);
        });
    }

    @Test
    public void testNativeQuery1(){
        Student student = dao.findNative(1l);
        System.out.println(student);
    }

    @Test
    public void testNativeQuery2(){
        List<Student> students = dao.findNatveStudentByExample("%liu%",12);
        students.forEach(student -> {
            System.out.println(student);
        });
    }


    @Transactional
    @Rollback(false)
    @Test
    public void testUpdateQuery(){
        dao.updateStudent("liuxinguai",27,27l);
    }

    @Transactional
    @Rollback(false)
    @Test
    public void testNativeUpdateQuery(){
        dao.updateNativeStudent("liuxin",27,27l);
    }


    @Transactional
    @Rollback(false)
    @Test
    public void testdeleteQuery(){
        dao.deleteStudent(27l);
    }

    @Transactional
    @Rollback(false)
    @Test
    public void testNativedeleteQuery(){
        dao.deleteNativeStudent(26l);
    }

    @Test
    public void testPageQuery(){
        Pageable pageable = PageRequest.of(0,10);
        Page<Student> page = dao.studentPage(pageable);
        page.forEach(student -> {
            System.out.println(student);
        });


        List<Sort.Order> orders = new ArrayList<>();
        orders.add(Sort.Order.desc("ID"));
        Sort sort = Sort.by(orders);
        pageable = PageRequest.of(0,10,sort);
        page = dao.studentPage(pageable);
        page.forEach(student -> {
            System.out.println(student);
        });
    }


}

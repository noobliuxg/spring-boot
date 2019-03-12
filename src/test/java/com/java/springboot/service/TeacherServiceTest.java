package com.java.springboot.service;

import com.java.springboot.Application;
import com.java.springboot.entity.Student;
import com.java.springboot.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TeacherServiceTest {
    @Autowired
    private TeacherService service;


    @Test
    public void testFindAll(){
        System.out.println(service);
        List<Teacher> teachers = service.findAll();
        teachers.forEach(teacher -> {
            System.out.println(teacher);
        });
    }

    @Test
    public void testFindOne(){
        Teacher teacher = service.findOne(12l);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("缓存后的对象："+service.findOne(12l));
    }

    @Test
    public void testDelete(){
        service.delete(12l);
        service.findOne(12l);
    }


    @Test
    public void testUpdate(){
        Teacher teacher = new Teacher();
        teacher.setId(12l);
        teacher.setTeaName("Mrs.Liuxg");
        teacher.setTeaAge(29);
        System.out.println("更新后放入缓存中的对象："+service.update(teacher));
        System.out.println("----------");
        System.out.println("缓存的teacher对象："+service.findOne(12l));
    }

}

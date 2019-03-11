package com.java.springboot.service;

import com.java.springboot.Application;
import com.java.springboot.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class StudentServiceTest {
    @Autowired
    private StudentService service;


    @Test
    public void testFindOne(){
        Student student = service.findOne(12l);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        student = service.findOne(12l);
    }
}

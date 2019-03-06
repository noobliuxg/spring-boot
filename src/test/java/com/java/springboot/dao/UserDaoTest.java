package com.java.springboot.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.springboot.Application;
import com.java.springboot.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserDaoTest {

    @Resource
    private UserMapper userMapper;


    @Transactional
    @Rollback(false)
    @Test
    public void insert(){
        for (int i=0;;){
            if (i>=20) break;
            i++;
            Student student = new Student();
            student.setStuName("liuxg"+i);
            student.setStuAge(12);
            userMapper.insert(student);
            System.out.println("获取到的ID:"+student.getId());
        }
    }

    @Test
    public void selectAll(){
        List<Student> students = userMapper.selectAll();

        students.forEach(student -> {
            System.out.println(student);
        });
    }

    @Test
    public void selectOne(){
        Student student = userMapper.selectOne(1);
        System.out.println(student);
    }

    @Test
    public void selectWhere(){
        Student student = new Student();
        student.setId(2);
        List<Student> students = userMapper.selectWhere(student);
        students.forEach(stu -> {
            System.out.println(stu);
        });
        student.setId(0l);
        student.setStuName("liuxg");
        students = userMapper.selectWhere(student);
        students.forEach(stu -> {
            System.out.println(stu);
        });
        student.setId(0l);
        student.setStuName(null);
        student.setStuAge(12);
        students = userMapper.selectWhere(student);
        students.forEach(stu -> {
            System.out.println(stu);
        });
    }


    @Test
    public void update(){
        Student student = new Student();
        student.setId(1l);
        student.setStuName("liuxinguai");
        student.setStuAge(15);
        userMapper.update(student);
    }


    @Test
    public void delete(){
        userMapper.delete(6);
    }


    @Test
    public void page(){
        PageHelper.startPage(1,10,"id desc");
        List<Student> students = userMapper.selectAll();
        PageInfo<Student> page = new PageInfo<>(students);
        List<Student> list = page.getList();
        list.forEach(stu -> {
            System.out.println(stu);
        });
    }

}

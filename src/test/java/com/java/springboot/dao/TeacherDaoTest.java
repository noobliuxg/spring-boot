package com.java.springboot.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.springboot.Application;
import com.java.springboot.entity.Student;
import com.java.springboot.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TeacherDaoTest {

    @Resource
    private TeacherMapper teacherMapper;


    @Transactional
    @Rollback(false)
    @Test
    public void insert(){
        for (int i=0;;){
            if (i>=6) break;
            i++;
            Teacher teacher = new Teacher();
            teacher.setTeaName("liuxg");
            teacher.setTeaAge(11);
            teacherMapper.insert(teacher);
            System.out.println("获取到的ID:"+teacher.getId());
        }
        for (int i=0;;){
            if (i>=20) break;
            i++;
            Teacher teacher = new Teacher();
            teacher.setTeaName("liuxg"+i);
            teacher.setTeaAge(12+i);
            teacherMapper.insert(teacher);
            System.out.println("获取到的ID:"+teacher.getId());
        }
    }

    @Test
    public void insertOne(){
        Teacher teacher = new Teacher();
        teacher.setTeaName("liuxg");
        teacher.setTeaAge(80);
        teacherMapper.insert(teacher);
        System.out.println("获取到的ID:"+teacher.getId());
    }

    @Test
    public void selectAll(){
        List<Teacher> teachers = teacherMapper.selectAll();

        teachers.forEach(teacher -> {
            System.out.println(teacher);
        });
    }

    @Test
    public void selectOne(){
        Teacher teacher = teacherMapper.selectOne(1);
        System.out.println(teacher);
    }

    @Test
    public void selectWhere(){
        Teacher teacher = new Teacher();
        teacher.setId(2);
        List<Teacher> students = teacherMapper.selectWhere(teacher);
        students.forEach(stu -> {
            System.out.println(stu);
        });
        teacher.setId(0l);
        teacher.setTeaName("liuxg");
        students = teacherMapper.selectWhere(teacher);
        students.forEach(stu -> {
            System.out.println(stu);
        });
        teacher.setId(0l);
        teacher.setTeaName(null);
        teacher.setTeaAge(12);
        students = teacherMapper.selectWhere(teacher);
        students.forEach(stu -> {
            System.out.println(stu);
        });
    }


    @Test
    public void update(){
        Teacher teacher = new Teacher();
        teacher.setId(1l);
        teacher.setTeaName("liuxinguai");
        teacher.setTeaAge(15);
        teacherMapper.update(teacher);
    }


    @Test
    public void delete(){
        teacherMapper.delete(26);
    }


    @Test
    public void page(){
        PageHelper.startPage(1,10,"id desc");
        List<Teacher> students = teacherMapper.selectAll();
        PageInfo<Teacher> page = new PageInfo<>(students);
        List<Teacher> list = page.getList();
        list.forEach(tea -> {
            System.out.println(tea);
        });
    }

}

package com.java.springboot.dao;

import com.java.springboot.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentDao extends JpaRepository<Student,Long> {

    @Query(value = "from Student ")
    List<Student> findAllStudent();

    @Query(value = "from Student where stuName like ?1 and stuAge = ?2")
    List<Student> findStudentByExample(String stuName,int stuAge);

    @Query(value = "from Student where id=?1")
    Student findStudent(long id);


    @Query(value="select * from STUDENT WHERE ID=?",nativeQuery = true)
    Student findNative(long id);


    @Query(value = "select * from STUDENT WHERE STU_NAME like ? and STU_AGE = ?",nativeQuery = true)
    List<Student> findNatveStudentByExample(String stuName,int stuAge);


    @Modifying
    @Query(value = "update Student stu set stu.stuName=?1,stu.stuAge=?2 where id=?3")
    int updateStudent(String stuName,int stuAge,long id);

    @Modifying
    @Query(value="UPDATE STUDENT SET STU_NAME = ? ,STU_AGE=? WHERE ID = ?",nativeQuery = true)
    int updateNativeStudent(String stuName,int stuAge,long id);

    @Modifying
    @Query(value="delete from Student where id=?1")
    int deleteStudent(long id);

    @Modifying
    @Query(value="delete from STUDENT WHERE ID=?",nativeQuery = true)
    int deleteNativeStudent(long id);



    @Query(
            value = "select * from STUDENT",
            countQuery = "select count(*) from STUDENT ",
            nativeQuery = true
    )
    Page<Student> studentPage(Pageable pageable);

}

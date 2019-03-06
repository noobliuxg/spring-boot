package com.java.springboot.dao;

import com.java.springboot.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert(value="insert into STUDENT(STU_NAME,STU_AGE) values(#{stu.stuName},#{stu.stuAge})")
    @Options(keyColumn = "ID",keyProperty = "stu.id",useGeneratedKeys = true)
    int insert(@Param("stu") Student stu);


    @Select(value = "select ID,STU_NAME,STU_AGE from STUDENT")
    @Results({
            @Result(property = "stuAge",column = "STU_AGE"),
            @Result(property = "stuName", column = "STU_NAME")
    })
    List<Student> selectAll();

    @Select(value = "SELECT ID,STU_NAME,STU_AGE from STUDENT WHERE ID=#{id}")
    @Results({
            @Result(property = "stuAge",column = "STU_AGE"),
            @Result(property = "stuName", column = "STU_NAME")
    })
    Student selectOne(@Param("id") long id);

    @Select("<script>" +
            "SELECT ID,STU_NAME,STU_AGE from STUDENT"
            +"<trim prefix=\"WHERE\" prefixOverrides=\"AND |OR \">"
            +"<if test=\"student.id > 0 \"> and ID=#{student.id}</if>"
            +"<if test=\"student.stuName != null\"> and STU_NAME like #{student.stuName}</if>"
            +"<if test=\"student.stuAge > 0\"> and STU_AGE=#{student.stuAge}</if>"
            +"</trim>"
            +"</script>"
    )
    @Results({
            @Result(property = "stuAge",column = "STU_AGE"),
            @Result(property = "stuName", column = "STU_NAME")
    })
    List<Student> selectWhere(@Param("student") Student student);

    @Update("<script>" +
            "UPDATE STUDENT"
            +"<set>"
            +"<if test=\"student.stuName != null\"> STU_NAME=#{student.stuName},</if>"
            +"<if test=\"student.stuAge > 0\"> STU_AGE=#{student.stuAge}</if>"
            +"</set>"
            +"WHERE ID=#{student.id}"
            +"</script>"
    )
    int update(@Param("student") Student student);

    @Delete("delete from STUDENT where ID=#{id}")
    int delete(@Param("id") long id);

}

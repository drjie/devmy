package com.lz.dao;

import com.lz.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();
    List<Student> findByKeyword(@Param("name") String name, @Param("age") Integer age);
    List<Student> findByStudent(Student student);
    List<Student> findByStudentWithTrim(Student student);
    int update(Student student);
    int updateWithTrim(Student student);
    int deleteMore(Integer... ids);
}

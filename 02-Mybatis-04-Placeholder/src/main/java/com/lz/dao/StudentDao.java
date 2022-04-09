package com.lz.dao;

import com.lz.entity.Student;

import java.util.List;

public interface StudentDao {
  //查询指定年龄的学生
    List<Student> findByAge(String age);
    List<Student> findById(String id);
}

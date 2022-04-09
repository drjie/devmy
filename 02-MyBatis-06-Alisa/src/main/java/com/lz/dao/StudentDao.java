package com.lz.dao;

import com.lz.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();
    Student findById(Integer id);
    List<Student> findByName(String name);
    List<Student> findByAge(String age);
    List<Student> findByGender(String gender);
}

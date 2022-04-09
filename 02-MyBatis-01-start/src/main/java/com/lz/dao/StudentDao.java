package com.lz.dao;

import com.lz.entity.Student;

import java.util.List;

public interface StudentDao {
    Student findById();
    List<Student> findAll();
    Student findStudentById(Integer id);
}

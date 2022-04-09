package com.lz.dao;

import com.lz.entity.Department;

import java.util.List;

public interface DepartmentDao {
    List<Department> findAll();
}

package com.lz.dao;

import com.lz.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
}

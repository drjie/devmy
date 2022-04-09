package com.lz.test;

import com.lz.dao.DepartmentDao;
import com.lz.dao.EmployeeDao;
import com.lz.entity.Department;
import com.lz.entity.Employee;
import com.lz.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class LazyTest {
    @Test
    public void testDepartment(){
        DepartmentDao departmentDao = MyBatisUtil.getMapper(DepartmentDao.class);
        Department department = departmentDao.findById(4);
        System.out.println(department.getName());
        MyBatisUtil.commit();
    }
    @Test
    public void testEmployee(){
        EmployeeDao employeeDao = MyBatisUtil.getMapper(EmployeeDao.class);
        List<Employee> employees = employeeDao.findById(4);
        System.out.println(employees);
        MyBatisUtil.commit();
    }
}

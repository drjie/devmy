package com.lz.test;

import com.lz.dao.DepartmentDao;
import com.lz.dao.EmployeeDao;
import com.lz.dao.StudentDao;
import com.lz.dao.SubjectDao;
import com.lz.entity.Department;
import com.lz.entity.Employee;
import com.lz.entity.Student;
import com.lz.entity.Subject;
import com.lz.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class MoreTableTest {
    @Test
    public void testSubject(){
        SubjectDao subjectDao = MyBatisUtil.getMapper(SubjectDao.class);
        List<Subject> subjects = subjectDao.findAll();
        for (Subject subject : subjects) {
            System.out.println(subject);
        }
        MyBatisUtil.commit();
    }
    @Test
    public void testStudent(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        List<Student> students = studentDao.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
        MyBatisUtil.commit();
    }
    @Test
    public void testDepartment(){
        DepartmentDao departmentDao = MyBatisUtil.getMapper(DepartmentDao.class);
        List<Department> departments = departmentDao.findAll();
        for (Department department : departments) {
            System.out.println(department);
        }
        MyBatisUtil.commit();
    }
    @Test
    public void test(){
        EmployeeDao employeeDao = MyBatisUtil.getMapper(EmployeeDao.class);
        List<Employee> employees = employeeDao.findAll();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        MyBatisUtil.commit();
    }
}

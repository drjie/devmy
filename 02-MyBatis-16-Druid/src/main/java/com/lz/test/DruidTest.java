package com.lz.test;

import com.lz.dao.StudentDao;
import com.lz.entity.Student;
import com.lz.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class DruidTest {
    @Test
    public void test(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        List<Student> students = studentDao.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
        MyBatisUtil.commit();
    }
}

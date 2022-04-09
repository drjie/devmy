package com.lz.test;

import com.lz.dao.StudentDao;
import com.lz.entity.Student;
import com.lz.util.MyBatisUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class AnnotationTest {
    @Test
    public void testDelete(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        studentDao.delete(9);
        MyBatisUtil.commit();
    }
    @Test
    public void testUpdate(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(9);
        student.setInfo("人人都说好");
        studentDao.update(student);
        MyBatisUtil.commit();
    }
    @Test
    public void testInsert(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("老八");
        student.setAge(20);
        student.setGender("男");
        student.setBirthday(new Date());
        student.setInfo("秘制小汉堡");
        studentDao.insert(student);
        MyBatisUtil.commit();
    }
    @Test
    public void testFindById(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        Student student = studentDao.findById(1);
        System.out.println(student);
        MyBatisUtil.commit();
    }
    @Test
    public void testFindAll(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        List<Student> students = studentDao.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
        MyBatisUtil.commit();
    }
}

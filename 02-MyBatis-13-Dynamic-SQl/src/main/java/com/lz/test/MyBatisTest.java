package com.lz.test;

import com.lz.dao.StudentDao;
import com.lz.entity.Student;
import com.lz.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class MyBatisTest {
    @Test
    public void testDeleteMore(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        int i = studentDao.deleteMore(8);
        MyBatisUtil.commit();
    }
    @Test
    public void updateWithTrim(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(3);
        student.setInfo("四千年第一美女");
        int update = studentDao.updateWithTrim(student);
        MyBatisUtil.commit();
    }
    @Test
    public void findByStudentWithTrim(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        Student student = new Student();
        student.setGender("女");
        student.setAge(26);
        List<Student> students = studentDao.findByStudentWithTrim(student);
        for (Student student2 : students) {
            System.out.println(student2);
        }
    }
    @Test
    public void testUpdate(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(3);
        student.setInfo("四千年第一美女");
        int update = studentDao.update(student);
        MyBatisUtil.commit();
    }
    @Test
    public void testFindStudent(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        Student student = new Student();
        student.setGender("女");
        student.setAge(26);
        List<Student> students = studentDao.findByStudent(student);
        for (Student student2 : students) {
            System.out.println(student2);
        }
    }
    @Test
    public void testFindKeyword(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        List<Student> students = studentDao.findByKeyword("鞠婧祎", 24);
        for (Student student : students) {
            System.out.println(student);
        }
    }
    @Test
    public void testFindAll(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        List<Student> students = studentDao.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

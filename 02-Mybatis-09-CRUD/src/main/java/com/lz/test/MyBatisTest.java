package com.lz.test;

import com.lz.dao.StudentDao;
import com.lz.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testGetIncrement(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = new Student();
            student.setName("亚历山大");
            student.setAge((byte) 50);
            student.setGender("男");
            student.setInfo("压力三和达");
            int i = studentDao.getIncrement(student);
            System.out.println("是否成功"+i);
            System.out.println("获取自增长的id"+student.getId());
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindByKeyword() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            List<Student> students = studentDao.findByKeyword("%狗%");
            for (Student student : students) {
                System.out.println(student);
            }
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindByAll(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = studentDao.findById(62);
            System.out.println(student);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindAll(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            List<Student> students = studentDao.findALl();
            for (Student student : students) {
                System.out.println(student);
            }
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testUpdateInfo(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = new Student();
            student.setInfo("寝室的汪汪汪");
            student.setId(62);
            int insert = studentDao.update(student);
            System.out.println("受影响行数："+insert);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void delete(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            int i = studentDao.delete(45);
            System.out.println("受影响行数："+i);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   @Test
    public void insert(){
       try {
           InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
           SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
           SqlSession session = factory.openSession();
           StudentDao studentDao = session.getMapper(StudentDao.class);
           Student student = new Student();
           student.setName("温狗");
           student.setAge((byte) 20);
           student.setGender("男");
           student.setInfo("汪汪汪");
           int insert = studentDao.insert(student);
           System.out.println("受影响行数："+insert);
           session.commit();
           session.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}

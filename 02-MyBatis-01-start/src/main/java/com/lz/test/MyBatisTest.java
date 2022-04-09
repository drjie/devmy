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
import java.util.List;

public class MyBatisTest {
    @Test
    public void testFindStudentById(){
        //读取配置文件资源
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //构建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取连接
            SqlSession session = factory.openSession();
            //获取接口的实体类
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = studentDao.findStudentById(7);
            System.out.println(student);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindStudentById2(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = studentDao.findStudentById(48);
            System.out.println(student);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindStudentById3(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = studentDao.findStudentById(47);
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindAll(){
        //读取配置文件获取流
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //构建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取连接
            SqlSession session = factory.openSession();
            //获取接口的实现类
            StudentDao studentDao = session.getMapper(StudentDao.class);
            List<Student> students = studentDao.findAll();
            for (Student student : students) {
                System.out.println(student);
            }
            //提交事务
            session.commit();
            //关闭资源
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindALl2(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            List<Student> students = studentDao.findAll();
            for (Student student : students) {
                System.out.println(student);
            }
            session.commit();
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFIndAll3(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            List<Student> students = studentDao.findAll();
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
    public void testInsertface(){
        //读取文件获取流
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //构建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取连接
            SqlSession session = factory.openSession();
            //通过反射获取接口类的实现类
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = studentDao.findById();
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testInsertFace2(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = studentDao.findById();
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testInsertFace3(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = studentDao.findById();
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testInsert(){
        try {
            //读取配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //构建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //生产SqlSession 相当于queryRunner
            SqlSession session = factory.openSession();
            int i = session.insert("StudentMapper.insert");
            System.out.println("受影响行数："+i);
            //提交事务
            session.commit();
            //关闭资源
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testInsert2(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            int i = session.insert("Student.insertTow");
            System.out.println("受影响行数:"+i);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testInsert3(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            int i = session.insert("Student.insertThree");
            System.out.println("受影响行数:"+i);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test(){
        InputStream inputStream = null;
        try {
            //读取配置文件中的内容到流中
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //获取mybatis核心类对象SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //通过会话工厂获取连接 相当于queryRunner
            SqlSession sqlSession = sqlSessionFactory.openSession();
            Object o = sqlSession.selectOne("StudentMapper.select");
            System.out.println(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            Object o = session.selectOne("Student.select");
            System.out.println(o);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test3(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            Object o = session.selectOne("Student.select");
            System.out.println(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

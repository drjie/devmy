package com.lz.test;

import com.lz.dao.StudentDao;
import com.lz.entity.Student;
import com.lz.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

public class CacheTest {
    @Test
    public void testTwo(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            System.out.println("第一次查询");
            studentDao.findById(1);
            session.commit();
            System.out.println("第二次查询");
            studentDao.findById(1);
            Student student = new Student();
            student.setId(2);
            student.setInfo("测试缓存");
            studentDao.update(student);
            session.commit();
            System.out.println("第三次查询");
            studentDao.findById(1);
            session.commit();
            System.out.println("第四次查询");
            studentDao.findById(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void clearCache(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session= factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student1 = studentDao.findById(1);
            Student student = new Student();
            student.setId(2);
            student.setInfo("四千年第一美女");
            studentDao.update(student);
            Student student2 = studentDao.findById(1);
            System.out.println(student1==student2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testOne(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session1 = factory.openSession();
            SqlSession session2 = factory.openSession();
            StudentDao studentDao1 = session1.getMapper(StudentDao.class);
            StudentDao studentDao2 = session2.getMapper(StudentDao.class);
            Student student1 = studentDao1.findById(1);
//            清空缓存
//            session.clearCache();
//            session.commit();
            Student student2 = studentDao2.findById(1);
            System.out.println(student1==student2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

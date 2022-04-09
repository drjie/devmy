package com.lz.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.dao.StudentDao;
import com.lz.entity.Student;
import com.lz.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class PageHelperTest {
    @Test
    public void find(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        PageHelper.startPage(1,3);
        List<Student> students = studentDao.findAll();
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        System.out.println(pageInfo);
    }
    @Test
    public void findAll(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        PageHelper.startPage(1,3);
        List<Student> students = studentDao.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
        MyBatisUtil.commit();
    }
}

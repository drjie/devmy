package com.lz.test;

import com.lz.entity.Student;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {
    @Test
    public void testSelect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/rx04?useSSl=false&useUnicode=true&characterEncoding=UTF8";
            String username="root";
            String password="200202";
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql="select * from student";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //执行sql语句获取结果集
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Student> students = new ArrayList<>();
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getByte(3));
                student.setGender(resultSet.getString(4));
                student.setInfo(resultSet.getString(5));
                students.add(student);
            }
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSelect2(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/rx04?useSSL=false&useUnicode=true&characterEncoding=UTF8";
            String username="root";
            String password="200202";
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql="select * from student";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Student> students = new ArrayList<>();
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getByte(3));
                student.setGender(resultSet.getString(4));
                student.setInfo(resultSet.getString(5));
               students.add(student);
            }
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSelect3(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/rx04?useSSL=false&useUnicode=true&characterEncoding=UTF8";
            String username="root";
            String password="200202";
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql="select * from student";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Student> students = new ArrayList<>();
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getByte(3));
                student.setGender(resultSet.getString(4));
                student.setInfo(resultSet.getString(5));
                students.add(student);
            }
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testAdd(){
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //准备参数
            String url="jdbc:mysql://localhost:3306/rx04?useSSl=false&useUnicode=true&characterEncoding=UTF8";
            String username="root";
            String password="200202";
            String sql="insert into student(name,age,gender,info) values(?,?,?,?)";

            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"易烊千玺");
            preparedStatement.setInt(2,22);
            preparedStatement.setString(3,"男");
            preparedStatement.setString(4,"四个字");
            int i = preparedStatement.executeUpdate();
            System.out.println("受影响行数:"+i);
        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testAdd2(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/rx04?useSSL=false&useUnicode=true&characterEncoding=UTF8";
            String username="root";
            String password="200202";
            String sql="insert into student(name,age,gender,info) values(?,?,?,?)";
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"鞠婧祎");
            preparedStatement.setInt(2,25);
            preparedStatement.setString(3,"女");
            preparedStatement.setString(4,"sss");
            int i = preparedStatement.executeUpdate();
            System.out.println("受影响行数："+i);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testAdd3(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/rx04?useSSl=false&useUnicode=true&characterEncoding=UTF8";
            String username="root";
            String password="200202";
            String sql="insert into student(name,age,gender,info) values(?,?,?,?)";
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"赵今麦");
            preparedStatement.setInt(2,25);
            preparedStatement.setString(3,"女");
            preparedStatement.setString(4,"sssss");
            int i = preparedStatement.executeUpdate();
            System.out.println("受影响行数："+i);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

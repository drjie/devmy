package com.lz.dao.impl;

import com.lz.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public class JDBCTemplateDaoImpl {
    //这个对象类似于queryRunner
    private JdbcTemplate jdbcTemplate;
    public List<User> findAll(){
        String sql="select * from user";
        //query方法需要传递两个参数
        //sql
        //BeanPropertyRowMapper
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return users;
    }
    public User findById(Integer id){
        String sql="select * from user where id=?";
        User users = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),id);
        return users;
    }
    //查询总记录数
    public int findCount(){
        String sql="select count(1) from user";
        Integer query = jdbcTemplate.queryForObject(sql, Integer.class);
        return query;
    }
    public int insert(User user){
        String sql="insert into user(username,password) values(?,?)";
        int update = jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
        return update;
    }
    public int update(User user){
        String sql="update user set password=? where id=?";
        int update = jdbcTemplate.update(sql, user.getPassword(), user.getId());
        return update;
    }
    public int delete(Integer id){
        String sql="delete from user where id=?";
        int update = jdbcTemplate.update(sql, id);
        return update;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

package com.lz.dao.impl;

import com.lz.dao.UserDao;
import com.lz.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
//repository中的id可写可不写不写默认是类名首字母小写
@Repository("userDaoMySQLImpl")
public class UserDaoMySQLImpl implements UserDao {
    @Override
    public List<User> findAll() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1,"杨幂","555555"));
        users.add(new User(2,"范冰冰","666666"));
        users.add(new User(3,"刘亦菲","888888"));
        return users;
    }
}

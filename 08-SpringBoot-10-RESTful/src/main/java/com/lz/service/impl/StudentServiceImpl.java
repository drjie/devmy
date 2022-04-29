package com.lz.service.impl;

import com.lz.dao.StudentDao;
import com.lz.entity.Student;
import com.lz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public int insert(Student student) {
        return studentDao.insert(student);
    }

    @Override
    public int update(Integer id, String info) {
        return studentDao.update(id,info);
    }

    @Override
    public int delete(Integer id) {
        return studentDao.delete(id);
    }
}

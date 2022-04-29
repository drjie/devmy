package com.lz.dao;

import com.lz.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    List<Student> findAll();

    int insert(Student student);

    int update(@Param("id") Integer id, @Param("info") String info);

    int delete(Integer id);

}

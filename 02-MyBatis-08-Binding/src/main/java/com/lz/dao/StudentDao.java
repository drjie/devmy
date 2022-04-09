package com.lz.dao;

import com.lz.entity.Student;
import org.apache.ibatis.annotations.Param;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

public interface StudentDao {
    Student findByIdAndName(Integer id,String name);
    Student findByAgeAndName(Integer age,String name);
    Student findByGenderAndName(@Param("gender") String Gender,@Param("name") String name);
    int insert(Map<String,Object> map);
    int insertStudent(Student student);
}

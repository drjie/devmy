package com.lz._01_ThirdLayerApplication.dao;

import com.lz._01_ThirdLayerApplication.entity.Student;

import java.util.List;

public interface StudentDao {
    int getTotalCount();

    List<Student> getList(int pageNo, int pageSize);
}


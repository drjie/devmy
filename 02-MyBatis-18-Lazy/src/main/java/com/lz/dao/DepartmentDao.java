package com.lz.dao;

import com.lz.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentDao {
    //根据id查询当前部门及对应所有员工
    Department findById(@Param("id") Integer id);
}

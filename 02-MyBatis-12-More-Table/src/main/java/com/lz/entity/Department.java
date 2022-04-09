package com.lz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private Integer id;
    private String name;
    //一对多关系，一个部门对应多个员工
    private List<Employee> employees;
}

package com.lz.factory;

import com.lz.entity.Student;

public class StudentStaticFactory {
    public static Student getStudent(){
        return new Student();
    }
}

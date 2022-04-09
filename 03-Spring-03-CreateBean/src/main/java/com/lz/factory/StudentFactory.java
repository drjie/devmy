package com.lz.factory;

import com.lz.entity.Student;

public class StudentFactory {
    public Student getStudent(){
        return new Student();
    }
}

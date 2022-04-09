package com.lz.test;

import com.lz.dao.StudentMapper;
import com.lz.entity.Student;
import com.lz.entity.StudentExample;
import com.lz.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class lazyTest {
    @Test
    public void test(){
        StudentMapper mapper = MyBatisUtil.getMapper(StudentMapper.class);
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andAgeNotEqualTo((byte)20);
        List<Student> students = mapper.selectByExampleWithBLOBs(example);
        System.out.println(students);
    }
}

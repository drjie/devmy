package com.lz._01_ThirdLayerApplication.service.impl;

import com.lz._01_ThirdLayerApplication.dao.StudentDao;
import com.lz._01_ThirdLayerApplication.dao.impl.StudentDaoImpl;
import com.lz._01_ThirdLayerApplication.entity.Student;
import com.lz._01_ThirdLayerApplication.service.StudentService;
import com.lz._01_ThirdLayerApplication.vo.PageInfo;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    // 业务逻辑层依赖数据访问层
    StudentDao studentDao = new StudentDaoImpl();

    @Override
    public PageInfo<Student> getPageInfo(int pageNo, int pageSize) {
        int totalCount = studentDao.getTotalCount();
        List<Student> list = studentDao.getList(pageNo, pageSize);

        return new PageInfo<>(totalCount, pageSize, pageNo, list);
    }
}


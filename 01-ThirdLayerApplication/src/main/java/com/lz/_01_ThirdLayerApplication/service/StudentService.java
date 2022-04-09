package com.lz._01_ThirdLayerApplication.service;

import com.lz._01_ThirdLayerApplication.entity.Student;
import com.lz._01_ThirdLayerApplication.vo.PageInfo;
// 业务层接口
public interface StudentService {
    PageInfo<Student> getPageInfo(int pageNo, int pageSize);
}

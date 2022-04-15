package com.lz.service;

import com.lz.entity.VolunteerRecruitment;
import com.lz.vo.ResultVo;

import java.util.Date;
import java.util.Map;

public interface VolunteerRecruitmentService {

    ResultVo getList(Integer pageNum, Integer pageSize, Long id);

    ResultVo add(VolunteerRecruitment volunteerRecruitment);

    ResultVo update(VolunteerRecruitment volunteerRecruitment);

    ResultVo delete(Long id);

    ResultVo click(Long id, Date lastClickTime);

    ResultVo search(String val);
}

package com.lz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.dao.VolunteerRecruitmentMapper;
import com.lz.entity.VolunteerRecruitment;
import com.lz.service.VolunteerRecruitmentService;
import com.lz.vo.DataVo;
import com.lz.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VolunteerRecruitmentServiceImpl implements VolunteerRecruitmentService {
    @Autowired
    private VolunteerRecruitmentMapper volunteerRecruitmentMapper;

    @Override
    public ResultVo getList(Integer pageNum, Integer pageSize, Long id) {
        ResultVo resultVo;
        DataVo<VolunteerRecruitment> volunteerRecruitmentDataVo;
        List<VolunteerRecruitment> volunteerRecruitments;

        if (id!=null){
            volunteerRecruitments=new ArrayList<>();

            VolunteerRecruitment volunteerRecruitment = volunteerRecruitmentMapper.selectByPrimaryKey(id);

            if (volunteerRecruitment==null){
                volunteerRecruitmentDataVo=new DataVo<>(0L,volunteerRecruitments,pageNum,pageSize);
                resultVo=new ResultVo(4000,"未查到志愿者",false,volunteerRecruitmentDataVo);
            }else {
                //如果是查询单个那么点击量应该加1
                click(volunteerRecruitment.getId(),null);

                //更新点击次数

                volunteerRecruitment.setClickNum(volunteerRecruitment.getClickNum()+1);

                volunteerRecruitments.add(volunteerRecruitment);

                volunteerRecruitmentDataVo=new DataVo<>(0L,volunteerRecruitments,pageNum,pageSize);

                resultVo=new ResultVo(1000,"查到了志愿者",true,volunteerRecruitmentDataVo);
            }
        }else {
            PageHelper.startPage(pageNum,pageSize);

            volunteerRecruitments=volunteerRecruitmentMapper.selectByExample(null);

            if (volunteerRecruitments.size()==0){
                volunteerRecruitmentDataVo=new DataVo<>(0L,volunteerRecruitments,pageNum,pageSize);

                resultVo=new ResultVo(4100,"没有志愿者",false,volunteerRecruitmentDataVo);
            }else {
                PageInfo<VolunteerRecruitment> pageInfo = new PageInfo<>(volunteerRecruitments);

                volunteerRecruitmentDataVo=new DataVo<>(pageInfo.getTotal(),volunteerRecruitments,pageNum,pageSize);

                resultVo=new ResultVo(1100,"志愿者查询成功",true,volunteerRecruitmentDataVo);
            }
        }
        return resultVo;
    }

    @Override
    public ResultVo add(VolunteerRecruitment volunteerRecruitment) {
        ResultVo vo;

        //判断是否有创建时间没有就自己加上去
        if (volunteerRecruitment.getCreateTime()==null){
            volunteerRecruitment.setCreateTime(Calendar.getInstance(Locale.CHINA).getTime());
        }

        // 新创建的扶贫政策，点击量应该是0
        volunteerRecruitment.setClickNum(0);
        volunteerRecruitment.setLastClickTime(null);

        int i = volunteerRecruitmentMapper.insertSelective(volunteerRecruitment);

        if (i>0){
            vo=new ResultVo(1000,"添加志愿者成功",true,volunteerRecruitment);
        }else {
            vo=new ResultVo(5000,"添加志愿者失败",false,null);
        }


        return vo;
    }

    @Override
    public ResultVo update(VolunteerRecruitment volunteerRecruitment) {
        ResultVo vo;

        int i = volunteerRecruitmentMapper.updateByPrimaryKeySelective(volunteerRecruitment);

        if (i>0){
            //修改之后再重新查询一次保证返回给前端最新最全的数据
            volunteerRecruitment = volunteerRecruitmentMapper.selectByPrimaryKey(volunteerRecruitment.getId());
            vo=new ResultVo(1000,"修改志愿者成功",true,volunteerRecruitment);
        }else {
            vo=new ResultVo(5000,"修改志愿者失败",false,null);
        }
        return vo;
    }

    @Override
    public ResultVo delete(Long id) {
        ResultVo vo;

        int i = volunteerRecruitmentMapper.deleteByPrimaryKey(id);

        if (i>0){
            vo=new ResultVo(1000,"删除志愿者成功",true,null);
        }else {
            vo=new ResultVo(5000,"删除志愿者失败",false,null);
        }
        return vo;
    }

    @Override
    public ResultVo click(Long id, Date lastClickTime) {
        ResultVo vo;

        if (lastClickTime==null){
            lastClickTime=new Date();
        }

        int i = volunteerRecruitmentMapper.click(id, lastClickTime);

        if (i>0){
            vo=new ResultVo(1000,"播放量加1成功！！",true,null);
        }else {
            vo=new ResultVo(5000,"播放量加1失败！！",false,null);
        }
        return vo;
    }
}

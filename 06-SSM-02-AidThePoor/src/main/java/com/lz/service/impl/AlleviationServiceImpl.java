package com.lz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.dao.AlleviationMapper;
import com.lz.entity.Alleviation;
import com.lz.entity.AlleviationExample;
import com.lz.service.AlleviationService;
import com.lz.vo.DataVo;
import com.lz.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlleviationServiceImpl implements AlleviationService {
    @Autowired
    private AlleviationMapper alleviationMapper;

    @Override
    public ResultVo getList(Integer pageNum, Integer pageSize, Long id) {
        ResultVo resultVo;
        DataVo<Alleviation> alleviationDataVo;
        List<Alleviation> alleviations;
        if (id != null) {
            alleviations = new ArrayList<>();

            Alleviation alleviation = alleviationMapper.selectByPrimaryKey(id);

            if (alleviation == null) {
                alleviationDataVo = new DataVo<>(0L, alleviations, pageNum, pageSize);
                resultVo = new ResultVo(4000, "没有拿到项目", false, alleviationDataVo);
            } else {
                //如果是查询单个那么点击量应该加1
                click(alleviation.getId(), null);

                //更新点击次数

                alleviation.setClickNum(alleviation.getClickNum() + 1);

                alleviations.add(alleviation);

                alleviationDataVo = new DataVo<>(1L, alleviations, pageNum, pageSize);
                resultVo = new ResultVo(1000, "查到了项目", true, alleviationDataVo);
            }
        } else {
            PageHelper.startPage(pageNum, pageSize);

            alleviations = alleviationMapper.selectByExample(null);

            if (alleviations.size() == 0) {
                alleviationDataVo = new DataVo<>(0L, alleviations, pageNum, pageSize);
                resultVo = new ResultVo(4000, "没有项目", false, alleviationDataVo);
            } else {
                PageInfo<Alleviation> pageInfo = new PageInfo<>(alleviations);

                alleviationDataVo = new DataVo<>(pageInfo.getTotal(), alleviations, pageNum, pageSize);

                resultVo = new ResultVo(1000, "查询项目成功", true, alleviationDataVo);
            }
        }
        return resultVo;
    }

    @Override
    public ResultVo add(Alleviation alleviation) {
        ResultVo resultVo;

        if (alleviation.getCreateTime() == null) {
            alleviation.setCreateTime(Calendar.getInstance(Locale.CHINA).getTime());
        }

        // 新创建的扶贫政策，点击量应该是0
        alleviation.setClickNum(0);
        alleviation.setLastClickTime(null);

        int i = alleviationMapper.insertSelective(alleviation);

        if (i > 0) {
            resultVo = new ResultVo(1000, "添加项目成功", true, alleviation);
        } else {
            resultVo = new ResultVo(5000, "添加项目失败", false, null);
        }

        return resultVo;
    }

    @Override
    public ResultVo update(Alleviation alleviation) {
        ResultVo resultVo;
        System.out.println(alleviation);
        alleviation.setReleaseTime(new Date());

        int i = alleviationMapper.updateByPrimaryKeySelective(alleviation);

        if (i > 0) {
            alleviation = alleviationMapper.selectByPrimaryKey(alleviation.getId());
            resultVo = new ResultVo(1000, "修改项目成功", true, alleviation);
        } else {
            resultVo = new ResultVo(5000, "修改项目失败", false, null);
        }
        return resultVo;
    }

    @Override
    public ResultVo delete(Long id) {
        ResultVo resultVo;

        int i = alleviationMapper.deleteByPrimaryKey(id);

        if (i > 0) {
            resultVo = new ResultVo(1000, "删除项目成功", true, null);
        } else {
            resultVo = new ResultVo(5000, "删除项目失败", false, null);
        }
        return resultVo;
    }

    @Override
    public ResultVo click(Long id, Date lastClickTime) {

        if (lastClickTime == null) {
            lastClickTime = new Date();
        }

        ResultVo vo;

        int i = alleviationMapper.click(id, lastClickTime);

        if (i > 0) {
            vo = new ResultVo(1000, "播放量加1成功！！", true, null);
        } else {
            vo = new ResultVo(5000, "播放量加1失败！！", false, null);
        }
        return vo;
    }

    @Override
    public ResultVo search(String val) {
        DataVo<Alleviation> alleviationDataVo;

        List<Alleviation> alleviations;

        ResultVo vo;

        AlleviationExample alleviationExample = new AlleviationExample();

        AlleviationExample.Criteria criteria = alleviationExample.createCriteria();

        criteria.andTitleLike("%" + val + "%");

        alleviations = alleviationMapper.selectByExample(alleviationExample);

        System.out.println(alleviations);
        if (alleviations==null){
            alleviationDataVo = new DataVo<>(0L, alleviations,null,null);
            vo = new ResultVo(4000, "没有搜索到", false, alleviationDataVo);
        }else {

            alleviationDataVo = new DataVo<>(1L, alleviations, null, null);
            vo = new ResultVo(1000, "搜索到", true, alleviationDataVo);
        }
        return vo;

    }
}

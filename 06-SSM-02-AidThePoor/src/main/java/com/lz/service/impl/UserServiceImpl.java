package com.lz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.dao.UserMapper;
import com.lz.entity.UserExample;
import com.lz.entity.PoorWithBLOBs;
import com.lz.entity.User;
import com.lz.entity.UserExample;
import com.lz.service.UserService;
import com.lz.vo.DataVo;
import com.lz.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultVo getList(Integer pageNum, Integer pageSize, Long id) {
        //返回前端的结果
        ResultVo resultVo;
        //分页相关的参数
        DataVo<User> userDataVo;
        //结果中data对应的用户数组
        List<User> users;
        //说明传递了id那就是findById
        if (id != null) {
            users = new ArrayList<>();

            User user = userMapper.selectByPrimaryKey(id);

            if (user == null) {

                userDataVo = new DataVo<>(0L, users, pageNum, pageSize);

                resultVo = new ResultVo(4000, "查无此人", false, userDataVo);
            } else {
                users.add(user);

                userDataVo = new DataVo<>(1L, users, pageNum, pageSize);

                resultVo = new ResultVo(1000, "查到了用户", true, userDataVo);
            }
        } else {
            //开启分页
            PageHelper.startPage(pageNum, pageSize);

            users = userMapper.selectByExample(null);

            if (users.size() == 0) {
                userDataVo = new DataVo<>(0L, users, pageNum, pageSize);

                resultVo = new ResultVo(4100, "没有用户", false, userDataVo);
            } else {
                //封装pageInfo 获取总数据量
                PageInfo<User> pageInfo = new PageInfo<>(users);

                userDataVo = new DataVo<>(pageInfo.getTotal(), users, pageNum, pageSize);

                resultVo = new ResultVo(1100, "用户查询成功", true, userDataVo);
            }
        }
        return resultVo;
    }

    @Override
    public ResultVo add(User user) {
        ResultVo vo;

        //判断是否有创建时间没有就自己加上去
        if (user.getCreateTime() == null) {
            user.setCreateTime(Calendar.getInstance(Locale.CHINA).getTime());
        }

        int i = userMapper.insertSelective(user);

        if (i > 0) {
            vo = new ResultVo(1000, "添加用户成功", true, user);
        } else {
            vo = new ResultVo(5000, "添加用户失败", false, null);
        }

        return vo;
    }

    @Override
    public ResultVo update(User user) {
        ResultVo vo;

        int i = userMapper.updateByPrimaryKeySelective(user);

        if (i > 0) {
            //修改之后再重新查询一次保证返回给前端最新最全的数据
            user = userMapper.selectByPrimaryKey(user.getId());
            vo = new ResultVo(1000, "修改用户成功", true, user);
        } else {
            vo = new ResultVo(5000, "修改用户失败", false, null);
        }
        return vo;
    }

    @Override
    public ResultVo delete(Long id) {
        ResultVo vo;

        int i = userMapper.deleteByPrimaryKey(id);

        if (i > 0) {
            vo = new ResultVo(1000, "删除用户成功", true, null);
        } else {
            vo = new ResultVo(5000, "删除用户失败", false, null);
        }
        return vo;
    }

    @Override
    public ResultVo search(String val) {

        DataVo<User> userDataVo;

        List<User> users;

        ResultVo vo;

        UserExample userExample = new UserExample();

        UserExample.Criteria criteria = userExample.createCriteria();

        criteria.andNameLike("%" + val + "%");

        users = userMapper.selectByExample(userExample);

        if (users==null){
            userDataVo = new DataVo<>(0L, users,null,null);
            vo = new ResultVo(4000, "没有搜索到", false, userDataVo);
        }else {

            userDataVo = new DataVo<>(1L, users, null, null);
            vo = new ResultVo(1000, "搜索到了", true, userDataVo);
        }
        return vo;
    }
}

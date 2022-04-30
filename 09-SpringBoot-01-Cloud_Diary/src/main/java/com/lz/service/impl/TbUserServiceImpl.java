package com.lz.service.impl;

import com.lz.dao.TbUserMapper;
import com.lz.entity.TbUser;
import com.lz.entity.TbUserExample;
import com.lz.service.TbUserService;
import com.lz.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserMapper tbUserMapper;
    @Override
    public ResultVO login(String username, String password) {
        ResultVO vo = new ResultVO();

        TbUserExample tbUserExample = new TbUserExample();

        TbUserExample.Criteria criteria = tbUserExample.createCriteria();

        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);

        List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);

        if (tbUsers.size()>0){
            vo=new ResultVO(200,"登录成功",true,tbUsers.get(0));
        }else {
            vo=new ResultVO(0,"登录失败,用户名或者密码错误",false,null);
        }

        return vo;
    }

    @Override
    public ResultVO userCenter() {
        List<TbUser> users = tbUserMapper.selectByExample(null);
        ResultVO resultVo;
        if (users.size() == 0) {

            resultVo = new ResultVO(0, "没有用户", false, null);
        } else {

            resultVo = new ResultVO(200, "用户查询成功", true, users);
        }

        return resultVo;
    }

    @Override
    public TbUser update(MultipartFile file, TbUser tbUser,String type) {
        ResultVO resultVo = null;
        if (!file.isEmpty()){
            String path = "D:\\server\\apache-tomcat-8.5.37\\webapps\\upload\\cloud_diary\\"+type;
            //获取文件名
            File pathFile = new File(path);

            //如果路径不存在
            if (!pathFile.exists()){
                //创建多级路径
                pathFile.mkdirs();
            }

            String originalFilename = file.getOriginalFilename();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            //获取指定格式的日期字符串
            String format = formatter.format(new Date());
            //获取后缀名
            String  suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            //拼接
            originalFilename = format + suffix;

            try {
                HashMap<Object, Object> map = new HashMap<>();
                //上传
                file.transferTo(new File(path, originalFilename));

                map.put("imgurl","http://localhost:8081/upload/cloud_diary/"+type+"/"+originalFilename);
                resultVo.setCode(200);
                resultVo.setSuccess(true);
                resultVo.setMessage("文件上传成功");
                resultVo.setData(map);

            } catch (IOException e) {
                e.printStackTrace();
                resultVo.setCode(-1000);
                resultVo.setSuccess(false);
                resultVo.setMessage("文件上传失败");
            }
        }else {
            int i = tbUserMapper.updateByPrimaryKeySelective(tbUser);
            if (i>0){
                //修改之后再重新查询一次保证返回给前端最新最全的数据
                tbUser = tbUserMapper.selectByPrimaryKey(tbUser.getId());
                resultVo = new ResultVO(0, "修改失败", false, tbUser);
            }else {
                resultVo = new ResultVO(200, "修改成功", true, null);
            }
        }
        return tbUser;
    }

    @Override
    public int checkNick(TbUser tbUser) {

        TbUserExample tbUserExample = new TbUserExample();

        TbUserExample.Criteria criteria = tbUserExample.createCriteria();

        criteria.andUsernameLike("%"+tbUser.getUsername()+"%");

        List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);

        if (tbUsers!=null){
            return 0;
        }

        return 1;
    }

}

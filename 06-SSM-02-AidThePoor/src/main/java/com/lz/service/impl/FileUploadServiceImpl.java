package com.lz.service.impl;

import com.lz.service.FileUploadService;
import com.lz.vo.ResultVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Override
    public ResultVo upload(MultipartFile file, String type) {
        String path = "D:\\server\\apache-tomcat-8.5.37\\webapps\\upload\\AidThePoor\\"+type;
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

        ResultVo resultVo = new ResultVo();
        try {
            HashMap<Object, Object> map = new HashMap<>();
            //上传
            file.transferTo(new File(path, originalFilename));

            map.put("imgurl","http://localhost:8081/upload/AidThePoor/"+type+"/"+originalFilename);
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
        return resultVo;
    }
}

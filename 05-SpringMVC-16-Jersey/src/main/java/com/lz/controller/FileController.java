package com.lz.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("file")
public class FileController {
    @RequestMapping("upload")
    public ModelAndView upload(MultipartFile upload, ModelAndView mv) {

        String path = "http://localhost:8081/upload/";
        //获取文件名
        String filename = upload.getOriginalFilename();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        //获取指定格式的日期字符串
        String format = formatter.format(new Date());
        //获取后缀名
        filename = filename.substring(filename.lastIndexOf("."));
        //拼接
        filename = format + filename;
        try {
            //创建
            Client client = Client.create();

            //解析路径资源
            WebResource resource = client.resource(path + filename);
            resource.put(upload.getBytes());
            //上传
            upload.transferTo(new File(path, filename));

            mv.addObject("img", path+filename);

            mv.setViewName("/success.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mv;
    }
}

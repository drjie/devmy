package com.lz.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class FileUploadUtil {
    public static String fileUpload(MultipartFile file){
        String path="D:\\server\\apache-tomcat-8.5.37\\webapps\\upload";

        File location=new File(path);

        //不存在就创建
        if(!location.exists()){
            location.mkdirs();
        }

        String originalFilename = file.getOriginalFilename();

        //获取后缀名
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        String prefix = formatter.format(new Date());

        originalFilename=prefix+suffix;

        try {
            file.transferTo(new File(location,originalFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "http://localhost:8081/upload/"+originalFilename;
    }
}

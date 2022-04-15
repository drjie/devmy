package com.lz.controller;

import com.lz.service.FileUploadService;
import com.lz.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController

public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;
    @PostMapping ("uploadImg")
    public ResultVo upload(MultipartFile file,@RequestParam String type) {
        return fileUploadService.upload(file,type);
    }
}


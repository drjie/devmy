package com.lz.service;

import com.lz.vo.ResultVo;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    ResultVo upload(MultipartFile file, String type);
}

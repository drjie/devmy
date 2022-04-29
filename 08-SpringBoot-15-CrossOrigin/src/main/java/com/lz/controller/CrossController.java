package com.lz.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cross")
//@CrossOrigin(maxAge = 3600,
//        origins = "http://127.0.0.1:8848",
//        allowCredentials = "true",
//        methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.HEAD,RequestMethod.POST,RequestMethod.OPTIONS})
public class CrossController {
    @RequestMapping("test")
    public String test() {
        return "请求成功";
    }
}

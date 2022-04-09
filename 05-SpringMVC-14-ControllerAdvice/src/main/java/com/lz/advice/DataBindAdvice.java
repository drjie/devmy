package com.lz.advice;

import com.lz.util.CustomFormatter;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;

@ControllerAdvice
public class DataBindAdvice {
    //所有的请求在到达Controller之前都会执行此方法
    @InitBinder
    public void parseDate(WebDataBinder binder){
        //添加自定义格式化器
        binder.addCustomFormatter(new CustomFormatter());
    }

    //InitBinder 中的参数对应的控制器方法入参中的参数
    //类似@RequestParam 也是用来进行参数绑定的
    @InitBinder("student")
    public void bindStudent(WebDataBinder binder){
        binder.setFieldDefaultPrefix("student.");
    }

    @InitBinder("student")
    public void bindTeacher(WebDataBinder binder){
        binder.setFieldDefaultPrefix("teacher.");
    }

    //指定映射的参数名
    @ModelAttribute("creatDateTime")
    public Date getCreatDateTime(){
        System.out.println("Controller 执行之前-----");
        return new Date();
    }
}

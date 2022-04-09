package com.lz.advice;

import com.lz.exception.SingletonDogException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

//携带@ControllerAdvice这个注解
@ControllerAdvice
public class ExceptionAdvice {
    //只要发送异常就会执行这个方法
    @ExceptionHandler(SingletonDogException.class)
    @ResponseBody
    public Map<String,Object> handleSingletonDogException(Exception exception){
        HashMap<String, Object> map = new HashMap<>();

        map.put("code","-1");
        map.put("message","路见不平一声吼");
        map.put("success",false);
        map.put("data",exception.getMessage());

        return map;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> handleException(Exception exception){
        HashMap<String, Object> map = new HashMap<>();

        map.put("code","-1");
        map.put("message",exception.getMessage());
        map.put("success",false);
        map.put("data",exception.getMessage());

        return map;
    }
}

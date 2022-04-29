package com.lz.advice;

import com.lz.vo.ResultVo;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = DuplicateKeyException.class)
    @ResponseBody
    public ResultVo exception(Exception e){
        return new ResultVo(5000,"输入了重复的名字请换一个",false,e.getMessage());
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public ResultVo exception(MissingServletRequestParameterException e){
        return new ResultVo(5000,"缺少重要的请求参数,请重新检查后再次发送",false,e.getMessage());
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public ResultVo exception(RuntimeException e){
        e.printStackTrace();
        return new ResultVo(5000,"系统操作异常请稍后重试，或者滴管理员",false,e.getMessage());
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ResultVo exception(HttpRequestMethodNotSupportedException e){
        return new ResultVo(5000,"请求方式有误,请查看文档",false,e.getMessage());
    }
}

package com.lz.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//如果发生异常就会执行resolveException方法
@Component
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();

        if (ex instanceof SingletonDogException){
            modelAndView.addObject("message","没有女朋友且emo");
        }else {
            modelAndView.addObject("message",ex.getMessage());
        }
        modelAndView.setViewName("/error.jsp");
        return modelAndView;
    }
}

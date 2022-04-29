package com.lz.config;

import com.lz.filter.MoneyFilter;
import com.lz.filter.sexFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.Collections;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<Filter> sexRegistrationBean(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();

        //设置过滤器到spring容器 相当于加上@Component注解
        bean.setFilter(new sexFilter());
        //设置当前过滤器的优先级
        bean.setOrder(-1);
//        ArrayList<String> set = new ArrayList<>();
//        set.add("/test");
//        set.add("/login.html");
        bean.setUrlPatterns(Collections.singletonList("/*"));
//        bean.setUrlPatterns(set);

        return bean;
    }

    @Bean
    public FilterRegistrationBean<Filter> moneyRegistrationBean(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();

        //设置过滤器到spring容器中 相当于@Component注解

        bean.setFilter(new MoneyFilter());

        //设置当前过滤器到优先级

        bean.setOrder(1);
        bean.setUrlPatterns(Collections.singletonList("/login"));

        return bean;
    }
}

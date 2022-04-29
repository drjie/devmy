package com.lz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CrossConfig implements WebMvcConfigurer {

    //控制器的访问路径
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //允许携带cookie
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedMethods("GET","POST","DELETE","PUT","OPTIONS")
                .maxAge(3600);
    }
}

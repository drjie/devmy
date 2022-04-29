package com.lz.config;


import com.lz.entity.Cat;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({Cat.class})
@Configuration
public class CatConfig {
}

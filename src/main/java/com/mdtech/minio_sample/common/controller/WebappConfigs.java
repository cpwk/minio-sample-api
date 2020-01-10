package com.mdtech.minio_sample.common.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebappConfigs extends WebMvcConfigurerAdapter {

    @Bean
    public HandlerInterceptor corsInterceptor() {
        return new DefaultInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}

package com.example.day07SessionPrac;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Webconfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor())
                .addPathPatterns("/admin").order(3);


        registry.addInterceptor(new SessionInterceptor())
                .addPathPatterns("/test");


        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/signup");
    }


}

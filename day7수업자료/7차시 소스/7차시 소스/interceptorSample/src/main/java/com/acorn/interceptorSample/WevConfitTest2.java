package com.acorn.interceptorSample;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class WevConfitTest2  implements WebMvcConfigurer  {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( new Test2Interceptor())
                .addPathPatterns("/**").order(1);
    }
}

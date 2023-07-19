package com.example.tripadvisor.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MemberInterceptor())
                .addPathPatterns("/frontdesk/favorite/**")
                .addPathPatterns("/frontdesk/product/addPage")
                .addPathPatterns("/frontdesk/profile/**")
                .addPathPatterns("/frontdesk/comments/add")
                .addPathPatterns("/frontdesk/member/edit");
    }
}

package com.tomalen.springlanuch.Intercepton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Author:钟炜宏
 * Date:2019/8/29
 * 拦截器
 */
@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {


    @Autowired
    private SessionInterceptor sessionInterceptor;

    //要拦截的路径    查看重写方法的快捷键Ctrl + o
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //表示拦截所有的请求
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**");
    }
}

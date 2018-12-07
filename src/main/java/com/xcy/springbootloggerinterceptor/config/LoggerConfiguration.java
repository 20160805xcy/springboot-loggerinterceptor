package com.xcy.springbootloggerinterceptor.config;

import com.xcy.springbootloggerinterceptor.interceptor.LoggerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author xcy
 * @date 2018/12/04 15:46
 * @description LoggerConfiguration配置类
 *              最重要的一步:将写好的拦截器(LoggerInterceptor)添加到springboot项目内,
 *              让springboot项目可以识别并进行拦截.
 * @since V1.0.0
 */
@Configuration
public class LoggerConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 可添加多个,可以指定path;
        InterceptorRegistration ir = registry.addInterceptor(new LoggerInterceptor());
        // /**是对所有的请求都做拦截
        ir.addPathPatterns("/**");
        // 不拦截的请求
        ir.excludePathPatterns("/loginfo/token",
                "/loginfo/register",
                "/swagger-resources/**",
                "/publicFile/download",
                "/css/**",
                "/js/**",
                "/images/**"
        );
    }
}



/**
 * 这里改成用>1.5.12.RELEASE版本,就没有报(extends WebMvcConfigurerAdapter)方法过时
 * 其实以前都是继承WebMvcConfigurerAdapter类 不过springBoot2.0以上 WebMvcConfigurerAdapter 方法过时,有两种替代方案:
 * 1、继承WebMvcConfigurationSupport
 * 2、实现WebMvcConfigurer
 * 但是继承WebMvcConfigurationSupport会让Spring-boot对mvc的自动配置失效.根据项目情况选择.现在大多数项目是前后端分离,
 *      并没有对静态资源有自动配置的需求所以继承WebMvcConfigurationSupport也未尝不可.
 */

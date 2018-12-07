package com.xcy.springbootloggerinterceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.xcy.springbootloggerinterceptor.mapper"})
public class SpringbootLoggerinterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLoggerinterceptorApplication.class, args);
    }
}

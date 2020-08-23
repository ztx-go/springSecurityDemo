package com.example.springsecuritydemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.springsecuritydemo.mapper")
@SpringBootApplication
public class SpringsecuritydemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecuritydemoApplication.class, args);
    }

}

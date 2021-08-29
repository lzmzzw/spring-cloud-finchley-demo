package com.lz.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//注解@EnableFeignClients注解开启Feign
@EnableFeignClients
@SpringBootApplication
public class ServiceFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceFeignApplication.class, args);
    }
}